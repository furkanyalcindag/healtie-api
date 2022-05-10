package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.ArticleDTO;
import com.comitfy.healtie.app.dto.requestDTO.ArticleRequestDTO;
import com.comitfy.healtie.app.dto.requestDTO.CertificateRequestDTO;
import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.ArticleMapper;
import com.comitfy.healtie.app.repository.ArticleRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.service.ArticleService;
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
    DoctorRepository doctorRepository;
    @Override
    protected ArticleService getService() {
        return articleService;
    }

    @Override
    protected ArticleMapper getMapper() {
        return articleMapper;
    }

    @PostMapping("/{doctorId}")
    public ResponseEntity<ArticleRequestDTO> save(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                      @PathVariable UUID doctorId, @RequestBody ArticleRequestDTO articleRequestDTO) {
        Optional<Doctor> optional = doctorRepository.findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(articleService.saveFromDoctor(doctorId, articleRequestDTO), HttpStatus.OK);
        }
    }
}
