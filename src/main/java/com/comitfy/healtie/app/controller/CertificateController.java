package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.CertificateDTO;
import com.comitfy.healtie.app.dto.requestDTO.CertificateRequestDTO;
import com.comitfy.healtie.app.entity.Certificate;
import com.comitfy.healtie.app.mapper.CertificateMapper;
import com.comitfy.healtie.app.repository.CertificateRepository;
import com.comitfy.healtie.app.service.CertificateService;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("certificate")
public class CertificateController extends BaseCrudController<CertificateDTO, CertificateRequestDTO, Certificate, CertificateRepository, CertificateMapper, CertificateService> {

    @Autowired
    CertificateService certificateService;

    @Autowired
    CertificateMapper certificateMapper;

    @Override
    protected CertificateService getService() {
        return certificateService;
    }

    @Override
    protected CertificateMapper getMapper() {
        return certificateMapper;
    }
}
