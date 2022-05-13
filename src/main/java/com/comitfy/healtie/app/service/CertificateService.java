package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.CertificateDTO;
import com.comitfy.healtie.app.dto.requestDTO.CertificateRequestDTO;
import com.comitfy.healtie.app.entity.Certificate;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.CertificateMapper;
import com.comitfy.healtie.app.repository.CertificateRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CertificateService extends BaseService<CertificateDTO, CertificateRequestDTO, Certificate, CertificateRepository, CertificateMapper> {

    @Autowired
    CertificateRepository certificateRepository;

    @Autowired
    CertificateMapper certificateMapper;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public CertificateRepository getRepository() {
        return certificateRepository;
    }

    @Override
    public CertificateMapper getMapper() {
        return certificateMapper;
    }

    public PageDTO<CertificateDTO> getCertificateByDoctor(UUID id, int page, int size) {
        Optional<Doctor> doctor = doctorRepository.findByUuid(id);
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        if (doctor.isPresent()) {
            return getMapper().pageEntityToPageDTO(certificateRepository.findAllByDoctor(pageable, doctor.get()));
        } else {
            return null;
        }
    }

    public CertificateRequestDTO saveCertificateByDoctor(UUID id, CertificateRequestDTO dto) {
        Optional<Doctor> doctor = doctorRepository.findByUuid(id);
        if (doctor.isPresent()) {
            Certificate certificate = getMapper().requestDTOToEntity(dto);
            certificate.setDoctor(doctor.get());
            certificateRepository.save(certificate);
            return dto;
        } else {
            return null;
        }
    }
}
