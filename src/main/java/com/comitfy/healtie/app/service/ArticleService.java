package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.ArticleDTO;
import com.comitfy.healtie.app.dto.requestDTO.ArticleRequestDTO;
import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.ArticleMapper;
import com.comitfy.healtie.app.repository.ArticleRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleService extends BaseService<ArticleDTO, ArticleRequestDTO, Article, ArticleRepository, ArticleMapper> {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public ArticleRepository getRepository() {
        return articleRepository;
    }

    @Override
    public ArticleMapper getMapper() {
        return articleMapper;
    }

    public ArticleRequestDTO saveFromDoctor(UUID id, ArticleRequestDTO dto) {
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
}
