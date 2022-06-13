package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.ArticleClickDTO;
import com.comitfy.healtie.app.dto.requestDTO.ArticleClickRequestDTO;
import com.comitfy.healtie.app.entity.ArticleClick;
import com.comitfy.healtie.app.mapper.ArticleClickMapper;
import com.comitfy.healtie.app.repository.ArticleClickRepository;
import com.comitfy.healtie.app.specification.ArticleClickSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ArticleClickService extends BaseService<ArticleClickDTO, ArticleClickRequestDTO, ArticleClick, ArticleClickRepository, ArticleClickMapper, ArticleClickSpecification> {

    @Autowired
    ArticleClickSpecification articleClickSpecification;
    @Autowired
    ArticleClickMapper articleClickMapper;
    @Autowired
    ArticleClickRepository articleClickRepository;

    @Override
    public ArticleClickRepository getRepository() {
        return articleClickRepository;
    }

    @Override
    public ArticleClickMapper getMapper() {
        return articleClickMapper;
    }

    @Override
    public ArticleClickSpecification getSpecification() {
        return articleClickSpecification;
    }

    /*public PageDTO<ArticleClickDTO> getClickedArticleByUser(int page, int size, User user) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return getMapper().pageEntityToPageDTO();

    }*/

    /*  public PageDTO<ArticleDTO> getLikedArticleByUser(int page, int size, User user) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return getMapper().pageEntityToPageDTO(articleRepository.getLikedArticleOfUser(pageable, user.getUuid()));
    }*/
}
