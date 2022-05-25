package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.ProfessionTranslationDTO;
import com.comitfy.healtie.app.dto.requestDTO.ProfessionTranslationRequestDTO;
import com.comitfy.healtie.app.entity.ProfessionTranslation;
import com.comitfy.healtie.app.mapper.ProfessionTranslationMapper;
import com.comitfy.healtie.app.repository.ProfessionTranslationRepository;
import com.comitfy.healtie.app.specification.ProfessionTranslationSpecification;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionTranslationService extends BaseService<ProfessionTranslationDTO, ProfessionTranslationRequestDTO, ProfessionTranslation, ProfessionTranslationRepository, ProfessionTranslationMapper, ProfessionTranslationSpecification> {

    @Autowired
    ProfessionTranslationRepository professionTranslationRepository;

    @Autowired
    ProfessionTranslationMapper professionTranslationMapper;

    @Autowired
    ProfessionTranslationSpecification professionTranslationSpecification;

    @Override
    public ProfessionTranslationRepository getRepository() {
        return professionTranslationRepository;
    }

    @Override
    public ProfessionTranslationMapper getMapper() {
        return professionTranslationMapper;
    }

    @Override
    public ProfessionTranslationSpecification getSpecification() {
        return professionTranslationSpecification;
    }
}
