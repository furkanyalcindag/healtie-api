package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.ProfessionDTO;
import com.comitfy.healtie.app.dto.requestDTO.ProfessionRequestDTO;
import com.comitfy.healtie.app.entity.Profession;
import com.comitfy.healtie.app.mapper.ProfessionMapper;
import com.comitfy.healtie.app.repository.ProfessionRepository;
import com.comitfy.healtie.app.service.ProfessionService;
import com.comitfy.healtie.app.specification.ProfessionSpecification;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profession")
public class ProfessionController extends BaseCrudController<ProfessionDTO, ProfessionRequestDTO, Profession, ProfessionRepository, ProfessionMapper, ProfessionSpecification, ProfessionService> {

    @Autowired
    ProfessionService professionService;

    @Autowired
    ProfessionMapper professionMapper;


    @Override
    protected ProfessionService getService() {
        return professionService;
    }

    @Override
    protected ProfessionMapper getMapper() {
        return professionMapper;
    }

}
