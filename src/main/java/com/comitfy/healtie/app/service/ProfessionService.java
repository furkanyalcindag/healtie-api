package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.ProfessionDTO;
import com.comitfy.healtie.app.dto.requestDTO.ProfessionRequestDTO;
import com.comitfy.healtie.app.entity.Profession;
import com.comitfy.healtie.app.mapper.ProfessionMapper;
import com.comitfy.healtie.app.repository.ProfessionRepository;
import com.comitfy.healtie.app.specification.ProfessionSpecification;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionService extends BaseService<ProfessionDTO, ProfessionRequestDTO, Profession, ProfessionRepository, ProfessionMapper, ProfessionSpecification> {

    @Autowired
    ProfessionRepository professionRepository;

    @Autowired
    ProfessionMapper professionMapper;

    @Autowired
    ProfessionSpecification professionSpecification;

    @Override
    public ProfessionRepository getRepository() {
        return professionRepository;
    }

    @Override
    public ProfessionMapper getMapper() {
        return professionMapper;
    }

    @Override
    public ProfessionSpecification getSpecification() {
        return professionSpecification;
    }
}
