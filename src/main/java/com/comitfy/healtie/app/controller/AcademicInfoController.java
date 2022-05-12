package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.AcademicInfoDTO;
import com.comitfy.healtie.app.dto.requestDTO.AcademicInfoRequestDTO;
import com.comitfy.healtie.app.entity.AcademicInfo;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.AcademicInfoMapper;
import com.comitfy.healtie.app.repository.AcademicInfoRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.service.AcademicInfoService;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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

    @Autowired
    AcademicInfoRepository academicInfoRepository;

    @Autowired
    DoctorRepository doctorRepository;


    @PostMapping("/{doctorId}")
    public ResponseEntity<AcademicInfoRequestDTO> save(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                       @PathVariable UUID doctorId, @RequestBody AcademicInfoRequestDTO academicInfoRequestDTO) {
        Optional<Doctor> optional = doctorRepository.findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(academicInfoService.saveAcademicInfoByDoctor(doctorId, academicInfoRequestDTO), HttpStatus.OK);
        }
    }


/*   @PutMapping("/{doctorId}")
    public ResponseEntity<String> update(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                         @PathVariable UUID doctorId, @RequestBody AcademicInfoRequestDTO academicInfoRequestDTO) {
        Optional<Doctor> optional = doctorRepository.findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            academicInfoRequestDTO.setLanguageEnum(LanguageEnum.valueOf(acceptLanguage));
            getService().update(doctorId, academicInfoRequestDTO);
            return new ResponseEntity<>("Doctor with the id " + doctorId + " was updated.", HttpStatus.OK);
        }
    }*/


}





