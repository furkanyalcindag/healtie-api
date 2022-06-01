package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.CommentDTO;
import com.comitfy.healtie.app.dto.requestDTO.CommentLikeRequestDTO;
import com.comitfy.healtie.app.dto.requestDTO.CommentRequestDTO;
import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Comment;
import com.comitfy.healtie.app.mapper.CommentMapper;
import com.comitfy.healtie.app.repository.ArticleRepository;
import com.comitfy.healtie.app.repository.CommentRepository;
import com.comitfy.healtie.app.specification.CommentSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService extends BaseService<CommentDTO, CommentRequestDTO, Comment, CommentRepository, CommentMapper, CommentSpecification> {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CommentSpecification commentSpecification;

    @Override
    public CommentRepository getRepository() {
        return commentRepository;
    }

    @Override
    public CommentMapper getMapper() {
        return commentMapper;
    }

    @Override
    public CommentSpecification getSpecification() {
        return commentSpecification;
    }


    public CommentRequestDTO saveCommentByArticle(UUID id, CommentRequestDTO dto, Article article, User user) {
        Optional<Article> article1 = articleRepository.findByUuid(id);
        if (article1.isPresent()) {
            Comment comment = getMapper().requestDTOToEntity(dto);
            comment.setArticle(article1.get());
            comment.setUser(user);
            commentRepository.save(comment);
            return dto;
        } else {
            return null;
        }
    }

    public void likeOrDislikeComment(CommentLikeRequestDTO commentLikeRequestDTO, Comment comment, User user) {
        if (commentLikeRequestDTO.isLike()) {
            comment.addLike(user);
        } else {
            comment.removeLike(user);
        }
        commentRepository.save(comment);
    }

/*


    public PageDTO<ArticleDTO> getArticleByDoctor(UUID id, int page, int size, LanguageEnum languageEnum) {
        Optional<Doctor> doctor = doctorRepository.findByUuid(id);
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        if (doctor.isPresent()) {

            PageDTO<ArticleDTO> pageDTO = getMapper().pageEntityToPageDTO(getRepository().findAllByDoctorAndLanguageEnum(pageable, doctor.get(), languageEnum));
            for (int i = 0; i < pageDTO.getData().size(); i++) {
                pageDTO.getData().get(i).setLikeCount(getRepository().getCountOfArticleLike(pageDTO.getData().get(i).getUuid()));

                pageDTO.getData().get(i).setSaveCount(getRepository().getCountOfArticleSave(pageDTO.getData().get(i).getUuid()));

            }

            return pageDTO;
        } else {
            return null;
        }
    }
*/

}
