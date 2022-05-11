package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.CertificateDTO;
import com.comitfy.healtie.app.dto.requestDTO.CertificateRequestDTO;
import com.comitfy.healtie.app.entity.Certificate;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.CertificateMapper;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.app.repository.CertificateRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.service.CertificateService;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("certificate")
public class CertificateController extends BaseCrudController<CertificateDTO, CertificateRequestDTO, Certificate, CertificateRepository, CertificateMapper, CertificateService> {

    @Autowired
    CertificateService certificateService;

    @Autowired
    CertificateMapper certificateMapper;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    protected CertificateService getService() {
        return certificateService;
    }

    @Override
    protected CertificateMapper getMapper() {
        return certificateMapper;
    }

    @PostMapping("/{doctorId}")
    public ResponseEntity<CertificateRequestDTO> save(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                      @PathVariable UUID doctorId, @RequestBody CertificateRequestDTO certificateRequestDTO) {
        Optional<Doctor> optional = doctorRepository.findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(certificateService.saveFromDoctor(doctorId, certificateRequestDTO), HttpStatus.OK);
        }
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<String> update(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                         @PathVariable UUID doctorId, @RequestBody CertificateRequestDTO certificateRequestDTO) {
        Optional<Doctor> optional = doctorRepository.findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            certificateRequestDTO.setLanguageEnum(LanguageEnum.valueOf(acceptLanguage));
            getService().update(doctorId, certificateRequestDTO);
            return new ResponseEntity<>("Doctor with the id " + doctorId + " was updated.", HttpStatus.OK);
        }
    }
}
