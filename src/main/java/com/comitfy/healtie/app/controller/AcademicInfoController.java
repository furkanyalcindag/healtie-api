package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.AcademicInfoDTO;
import com.comitfy.healtie.app.dto.DoctorDTO;
import com.comitfy.healtie.app.dto.requestDTO.AcademicInfoRequestDTO;
import com.comitfy.healtie.app.entity.AcademicInfo;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.AcademicInfoMapper;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.app.repository.AcademicInfoRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.service.AcademicInfoService;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("academicInfo")
public class AcademicInfoController extends BaseCrudController<AcademicInfoDTO, AcademicInfoRequestDTO, AcademicInfo, AcademicInfoRepository, AcademicInfoMapper, AcademicInfoService> {

    @Autowired
    AcademicInfoService academicInfoService;

    @Autowired
    AcademicInfoMapper academicInfoMapper;

    @Override
    protected AcademicInfoService getService() {
        return academicInfoService;
    }

    @Override
    protected AcademicInfoMapper getMapper() {
        return academicInfoMapper;
    }



/*    @Autowired
    AcademicInfoRepository academicInfoRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping("/doctors/{doctorId}/academicInfo")
    public AcademicInfo createAcademicInfo(@PathVariable(value = "doctorID") Long doctorId, @Valid @RequestParam AcademicInfo academicInfo){
        return doctorRepository.findById(doctorId).map(doctor -> {
            academicInfo.setDoctor(doctor);
            return academicInfoRepository.save(academicInfo);
        }).orElseThrow(() ->new ResourceNotFoundException());
    }*/

}
