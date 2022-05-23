package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.CommentDTO;
import com.comitfy.healtie.app.dto.requestDTO.CommentRequestDTO;
import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Comment;
import com.comitfy.healtie.app.mapper.CommentMapper;
import com.comitfy.healtie.app.repository.ArticleRepository;
import com.comitfy.healtie.app.repository.CommentRepository;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService extends BaseService<CommentDTO, CommentRequestDTO, Comment, CommentRepository, CommentMapper> {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public CommentRepository getRepository() {
        return commentRepository;
    }

    @Override
    public CommentMapper getMapper() {
        return commentMapper;
    }


    public PageDTO<CommentDTO> getCommentByArticle(UUID id, int page, int size) {
        Optional<Article> article = articleRepository.findByUuid(id);
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        if (article.isPresent()) {
            return getMapper().pageEntityToPageDTO(commentRepository.findAllByArticle(pageable, article.get()));
        } else {
            return null;
        }
    }

    public CommentRequestDTO saveCommentByArticle(UUID id, CommentRequestDTO dto,Article article,User user) {
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
/*
    public void commentArticle(CommentRequestDTO commentRequestDTO, Comment comment, User user){

        if (commentRequestDTO.isComment()){
            comment.setUser(user);
        }else {
            comment.setUser(user);
        }
        commentRepository.save(comment);
    }*/


    /*public void likeOrDislikeArticle(ArticleLikeRequestDTO articleLikeRequestDTO, Article article, User user) {

        if (articleLikeRequestDTO.isLike()) {
            article.addLike(user);
        } else {
            article.removeLike(user);
        }
        articleRepository.save(article);
    }

    public void saveOrNotSaveArticle(ArticleSaveRequestDTO articleSaveRequestDTO, Article article, User user) {
        if (articleSaveRequestDTO.isSave()) {
            article.addSave(user);
        } else {
            article.removeSave(user);
        }
        articleRepository.save(article);
    }
*/


}
