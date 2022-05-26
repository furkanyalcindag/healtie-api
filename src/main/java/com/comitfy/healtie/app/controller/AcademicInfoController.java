package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.AcademicInfoDTO;
import com.comitfy.healtie.app.dto.DoctorDTO;
import com.comitfy.healtie.app.dto.requestDTO.AcademicInfoRequestDTO;
import com.comitfy.healtie.app.entity.AcademicInfo;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.AcademicInfoMapper;
import com.comitfy.healtie.app.repository.AcademicInfoRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.service.AcademicInfoService;
import com.comitfy.healtie.app.service.DoctorService;
import com.comitfy.healtie.app.specification.AcademicInfoSpecification;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("academicInfo")
public class AcademicInfoController extends BaseCrudController<AcademicInfoDTO, AcademicInfoRequestDTO, AcademicInfo, AcademicInfoRepository, AcademicInfoMapper, AcademicInfoSpecification, AcademicInfoService> {

    @Autowired
    AcademicInfoService academicInfoService;

    @Autowired
    AcademicInfoMapper academicInfoMapper;

    @Autowired
    AcademicInfoRepository academicInfoRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorService doctorService;

    @Override
    protected AcademicInfoService getService() {
        return academicInfoService;
    }

    @Override
    protected AcademicInfoMapper getMapper() {
        return academicInfoMapper;
    }


    @PostMapping("/{doctorId}")
    public ResponseEntity<AcademicInfoRequestDTO> saveByDoctorId(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                                 @PathVariable UUID doctorId, @RequestBody AcademicInfoRequestDTO academicInfoRequestDTO) {
        DoctorDTO optional = doctorService.findByUUID(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(academicInfoService.saveAcademicInfoByDoctor(doctorId, academicInfoRequestDTO), HttpStatus.OK);
        }
    }

    @GetMapping("doctor/{doctorId}")
    public ResponseEntity<PageDTO<AcademicInfoDTO>> getByDoctorId(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                                  @PathVariable UUID doctorId, @RequestParam int pageNumber, @RequestParam int pageSize) {
        Optional<Doctor> optional = doctorService.getRepository().findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(academicInfoService.getAcademicInfoByDoctor(doctorId, pageNumber, pageSize), HttpStatus.OK);
        }
    }


}





