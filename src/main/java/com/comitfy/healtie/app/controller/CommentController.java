package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.CommentDTO;
import com.comitfy.healtie.app.dto.requestDTO.CommentRequestDTO;
import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Comment;
import com.comitfy.healtie.app.mapper.CommentMapper;
import com.comitfy.healtie.app.repository.CommentRepository;
import com.comitfy.healtie.app.service.ArticleService;
import com.comitfy.healtie.app.service.CommentService;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("comment")
public class CommentController extends BaseCrudController<CommentDTO, CommentRequestDTO, Comment, CommentRepository, CommentMapper, CommentService> {

    @Autowired
    ArticleService articleService;
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    CommentService commentService;

    @Autowired
    HelperService helperService;


    @Override
    protected CommentService getService() {
        return commentService;
    }

    @Override
    protected CommentMapper getMapper() {
        return commentMapper;
    }

    @PostMapping("/{articleId}")
    public ResponseEntity<CommentRequestDTO> save(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                  @PathVariable UUID articleId, @RequestBody CommentRequestDTO commentRequestDTO) {

        Article article = articleService.findEntityByUUID(articleId);
        User user = helperService.getUserFromSession();
        //commentService.saveCommentByArticle(articleId,commentRequestDTO,article,user);
        return new ResponseEntity<>(commentService.saveCommentByArticle(articleId, commentRequestDTO, article, user), HttpStatus.OK);
    }

/*
    @GetMapping("article/{articleId}")
    public ResponseEntity<PageDTO<CommentDTO>> getByArticleId(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                              @PathVariable UUID articleId, @RequestParam int pageNumber, @RequestParam int pageSize) {
        Optional<Article> optional = articleRepository.findByUuid(articleId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(commentService.getCommentByArticle(articleId, pageNumber, pageSize), HttpStatus.OK);
        }
    }
*/


}
