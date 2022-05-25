package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.LanguageDTO;
import com.comitfy.healtie.app.dto.requestDTO.LanguageRequestDTO;
import com.comitfy.healtie.app.entity.Language;
import com.comitfy.healtie.app.mapper.LanguageMapper;
import com.comitfy.healtie.app.repository.LanguageRepository;
import com.comitfy.healtie.app.specification.LanguageSpecification;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService extends BaseService<LanguageDTO, LanguageRequestDTO, Language, LanguageRepository, LanguageMapper, LanguageSpecification> {

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    LanguageMapper languageMapper;

    @Autowired
    LanguageSpecification languageSpecification;

    @Override
    public LanguageRepository getRepository() {
        return languageRepository;
    }

    @Override
    public LanguageMapper getMapper() {
        return languageMapper;
    }

    @Override
    public LanguageSpecification getSpecification() {
        return languageSpecification;
    }
}
