package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.DoctorDTO;
import com.comitfy.healtie.app.dto.requestDTO.DoctorRequestDTO;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.DoctorMapper;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.service.DoctorService;
import com.comitfy.healtie.app.specification.DoctorSpecification;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.BaseWithMultiLanguageCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseCrudController<DoctorDTO, DoctorRequestDTO, Doctor, DoctorRepository,DoctorMapper, DoctorSpecification,DoctorService> {

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DoctorService doctorService;
    @Override
    protected DoctorService getService() {
        return doctorService;
    }

    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }




}
