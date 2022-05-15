package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.ArticleDTO;
import com.comitfy.healtie.app.dto.requestDTO.ArticleRequestDTO;
import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.ArticleMapper;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.app.repository.ArticleRepository;
import com.comitfy.healtie.app.repository.CategoryRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseService;
import com.comitfy.healtie.util.common.BaseWithMultiLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class ArticleService extends BaseWithMultiLanguageService<ArticleDTO, ArticleRequestDTO, Article, ArticleRepository, ArticleMapper> {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ArticleRepository getRepository() {
        return articleRepository;
    }

    @Override
    public ArticleMapper getMapper() {
        return articleMapper;
    }


    public PageDTO<ArticleDTO> getArticleByDoctor(UUID id, int page, int size, LanguageEnum languageEnum) {
        Optional<Doctor> doctor = doctorRepository.findByUuid(id);
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        if (doctor.isPresent()) {
            return getMapper().pageEntityToPageDTO(articleRepository.findAllByDoctorAndLanguageEnum(pageable, doctor.get(),languageEnum));
        } else {
            return null;
        }
    }

    public ArticleRequestDTO saveArticleByDoctor(UUID id, ArticleRequestDTO dto) {
        Optional<Doctor> doctor = doctorRepository.findByUuid(id);
        if (doctor.isPresent()) {
            Article article = getMapper().requestDTOToEntity(dto);
            article.setDoctor(doctor.get());
            articleRepository.save(article);
            return dto;
        } else {
            return null;
        }
    }

/*
    public PageDTO<ArticleDTO> getArticleByCategory(UUID id, int page, int size) {
        Optional<Category> category = categoryRepository.findByUuid(id);
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        if (category.isPresent()) {
            return getMapper().pageEntityToPageDTO(articleRepository.findAllByCategory(pageable, category.get()));
        } else {
            return null;
        }
    }
*/


}
