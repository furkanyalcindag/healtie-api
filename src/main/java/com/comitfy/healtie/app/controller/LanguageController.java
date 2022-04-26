package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.LanguageDTO;
import com.comitfy.healtie.app.dto.requestDTO.LanguageRequestDTO;
import com.comitfy.healtie.app.entity.Language;
import com.comitfy.healtie.app.mapper.LanguageMapper;
import com.comitfy.healtie.app.repository.LanguageRepository;
import com.comitfy.healtie.app.service.LanguageService;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("language")
public class LanguageController extends BaseCrudController<LanguageDTO, LanguageRequestDTO, Language, LanguageRepository, LanguageMapper, LanguageService> {

    @Autowired
    LanguageMapper languageMapper;

    @Autowired
    LanguageService languageService;

    @Override
    protected LanguageService getService() {
        return languageService;
    }

    @Override
    protected LanguageMapper getMapper() {
        return languageMapper;
    }
}
