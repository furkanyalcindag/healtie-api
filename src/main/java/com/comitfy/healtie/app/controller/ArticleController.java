package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.ArticleDTO;
import com.comitfy.healtie.app.dto.requestDTO.ArticleRequestDTO;
import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Category;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.ArticleMapper;
import com.comitfy.healtie.app.repository.ArticleRepository;
import com.comitfy.healtie.app.repository.CategoryRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.service.ArticleService;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("article")
public class ArticleController extends BaseCrudController<ArticleDTO, ArticleRequestDTO, Article, ArticleRepository, ArticleMapper, ArticleService> {

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Override
    protected ArticleService getService() {
        return articleService;
    }

    @Override
    protected ArticleMapper getMapper() {
        return articleMapper;
    }

    @GetMapping("doctor/{doctorId}")
    public ResponseEntity<PageDTO<ArticleDTO>> getByDoctorId(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                             @PathVariable UUID doctorId, @RequestParam int pageNumber, @RequestParam int pageSize) {
        Optional<Doctor> optional = doctorRepository.findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(articleService.getArticleByDoctor(doctorId, pageNumber, pageSize), HttpStatus.OK);
        }
    }

/*    @GetMapping("category/{categoryId}")
    public ResponseEntity<PageDTO<ArticleDTO>> getByCategoryId(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                               @PathVariable UUID categoryId, @RequestParam int pageNumber, @RequestParam int pageSize) {
        Optional<Category> optional = categoryRepository.findByUuid(categoryId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(articleService.getArticleByCategory(categoryId, pageNumber, pageSize), HttpStatus.OK);
        }
    }*/


    @PostMapping("/{doctorId}")
    public ResponseEntity<ArticleRequestDTO> save(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                  @PathVariable UUID doctorId, @RequestBody ArticleRequestDTO articleRequestDTO) {
        Optional<Doctor> optional = doctorRepository.findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(articleService.saveArticleByDoctor(doctorId, articleRequestDTO), HttpStatus.OK);
        }
    }

}
