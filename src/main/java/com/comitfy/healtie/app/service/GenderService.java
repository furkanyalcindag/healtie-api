package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.GenderDTO;
import com.comitfy.healtie.app.dto.requestDTO.GenderRequestDTO;
import com.comitfy.healtie.app.entity.Gender;
import com.comitfy.healtie.app.mapper.GenderMapper;
import com.comitfy.healtie.app.repository.GenderRepository;
import com.comitfy.healtie.app.specification.GenderSpecification;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService extends BaseService<GenderDTO, GenderRequestDTO, Gender, GenderRepository, GenderMapper, GenderSpecification> {

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    GenderSpecification genderSpecification;

    @Autowired
    GenderMapper genderMapper;

    @Override
    public GenderRepository getRepository() {
        return genderRepository;
    }

    @Override
    public GenderMapper getMapper() {
        return genderMapper;
    }

    @Override
    public GenderSpecification getSpecification() {
        return genderSpecification;
    }
}
