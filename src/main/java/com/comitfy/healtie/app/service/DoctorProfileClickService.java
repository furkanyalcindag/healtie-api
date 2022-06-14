package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.ArticleClickDTO;
import com.comitfy.healtie.app.dto.DoctorProfileClickDTO;
import com.comitfy.healtie.app.dto.requestDTO.ArticleClickRequestDTO;
import com.comitfy.healtie.app.dto.requestDTO.DoctorProfileClickRequestDTO;
import com.comitfy.healtie.app.entity.ArticleClick;
import com.comitfy.healtie.app.entity.DoctorProfileClick;
import com.comitfy.healtie.app.mapper.ArticleClickMapper;
import com.comitfy.healtie.app.mapper.DoctorProfileClickMapper;
import com.comitfy.healtie.app.repository.ArticleClickRepository;
import com.comitfy.healtie.app.repository.DoctorProfileClickRepository;
import com.comitfy.healtie.app.specification.ArticleClickSpecification;
import com.comitfy.healtie.app.specification.DoctorProfileClickSpecification;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorProfileClickService extends BaseService<DoctorProfileClickDTO, DoctorProfileClickRequestDTO, DoctorProfileClick, DoctorProfileClickRepository, DoctorProfileClickMapper, DoctorProfileClickSpecification> {

    @Autowired
    DoctorProfileClickSpecification articleClickSpecification;
    @Autowired
    DoctorProfileClickMapper articleClickMapper;
    @Autowired
    DoctorProfileClickRepository articleClickRepository;

    @Override
    public DoctorProfileClickRepository getRepository() {
        return articleClickRepository;
    }

    @Override
    public DoctorProfileClickMapper getMapper() {
        return articleClickMapper;
    }

    @Override
    public DoctorProfileClickSpecification getSpecification() {
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
