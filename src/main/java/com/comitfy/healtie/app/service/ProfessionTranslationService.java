package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.ProfessionTranslationDTO;
import com.comitfy.healtie.app.dto.requestDTO.ProfessionTranslationRequestDTO;
import com.comitfy.healtie.app.entity.ProfessionTranslation;
import com.comitfy.healtie.app.mapper.ProfessionTranslationMapper;
import com.comitfy.healtie.app.repository.ProfessionTranslationRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionTranslationService extends BaseService<ProfessionTranslationDTO, ProfessionTranslationRequestDTO, ProfessionTranslation, ProfessionTranslationRepository, ProfessionTranslationMapper> {

    @Autowired
    ProfessionTranslationRepository professionTranslationRepository;

    @Autowired
    ProfessionTranslationMapper professionTranslationMapper;

    @Override
    public ProfessionTranslationRepository getRepository() {
        return professionTranslationRepository;
    }

    @Override
    public ProfessionTranslationMapper getMapper() {
        return professionTranslationMapper;
    }
}
