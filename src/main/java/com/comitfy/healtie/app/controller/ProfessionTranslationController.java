package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.ProfessionTranslationDTO;
import com.comitfy.healtie.app.dto.requestDTO.ProfessionTranslationRequestDTO;
import com.comitfy.healtie.app.entity.ProfessionTranslation;
import com.comitfy.healtie.app.mapper.ProfessionTranslationMapper;
import com.comitfy.healtie.app.repository.ProfessionTranslationRepository;
import com.comitfy.healtie.app.service.ProfessionTranslationService;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("professionTranslation")
public class ProfessionTranslationController extends BaseCrudController<ProfessionTranslationDTO, ProfessionTranslationRequestDTO, ProfessionTranslation, ProfessionTranslationRepository, ProfessionTranslationMapper, ProfessionTranslationService> {

    @Autowired
    ProfessionTranslationService professionTranslationService;

    @Autowired
    ProfessionTranslationMapper professionTranslationMapper;

    @Override
    protected ProfessionTranslationService getService() {
        return professionTranslationService;
    }

    @Override
    protected ProfessionTranslationMapper getMapper() {
        return professionTranslationMapper;
    }
}
