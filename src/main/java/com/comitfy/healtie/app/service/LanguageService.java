package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.LanguageDTO;
import com.comitfy.healtie.app.entity.Language;
import com.comitfy.healtie.app.mapper.LanguageMapper;
import com.comitfy.healtie.app.repository.LanguageRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService extends BaseService<LanguageDTO, Language, LanguageRepository, LanguageMapper> {

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    LanguageMapper languageMapper;

    @Override
    public LanguageRepository getRepository() {
        return languageRepository;
    }

    @Override
    public LanguageMapper getMapper() {
        return languageMapper;
    }
}
