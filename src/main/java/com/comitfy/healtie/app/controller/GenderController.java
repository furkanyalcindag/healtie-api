package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.GenderDTO;
import com.comitfy.healtie.app.dto.requestDTO.GenderRequestDTO;
import com.comitfy.healtie.app.entity.Gender;
import com.comitfy.healtie.app.mapper.GenderMapper;
import com.comitfy.healtie.app.repository.GenderRepository;
import com.comitfy.healtie.app.service.GenderService;
import com.comitfy.healtie.app.specification.GenderSpecification;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gender")
public class GenderController extends BaseCrudController<GenderDTO, GenderRequestDTO, Gender, GenderRepository, GenderMapper, GenderSpecification, GenderService> {

    @Autowired
    GenderService genderService;

    @Autowired
    GenderMapper genderMapper;

    @Override
    protected GenderService getService() {
        return genderService;
    }

    @Override
    protected GenderMapper getMapper() {
        return genderMapper;
    }
}
