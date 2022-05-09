package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.CertificateDTO;
import com.comitfy.healtie.app.dto.requestDTO.CertificateRequestDTO;
import com.comitfy.healtie.app.entity.Certificate;
import com.comitfy.healtie.app.repository.CertificateRepository;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CertificateMapper implements BaseMapper<CertificateDTO, CertificateRequestDTO, Certificate> {

    @Autowired
    CertificateRepository certificateRepository;

    @Override
    public CertificateDTO entityToDTO(Certificate entity) {
        CertificateDTO certificateDTO = new CertificateDTO();
        certificateDTO.setName(entity.getName());
        certificateDTO.setCertificateNo(entity.getCertificateNo());
        certificateDTO.setTakenFrom(entity.getTakenFrom());
        certificateDTO.setTakenDate(entity.getTakenDate());
        return certificateDTO;
    }

    @Override
    public Certificate dtoToEntity(CertificateDTO dto) {
        Certificate certificate = new Certificate();
        certificate.setName(dto.getName());
        certificate.setCertificateNo(dto.getCertificateNo());
        certificate.setTakenFrom(dto.getTakenFrom());
        certificate.setTakenDate(dto.getTakenDate());
        return certificate;
    }

    @Override
    public Certificate requestDTOToEntity(CertificateRequestDTO dto) {
        Certificate certificate = new Certificate();
        certificate.setName(dto.getName());
        certificate.setCertificateNo(dto.getCertificateNo());
        certificate.setTakenFrom(dto.getTakenFrom());
        certificate.setTakenDate(dto.getTakenDate());
        return certificate;
    }

    @Override
    public Certificate requestDTOToExistEntity(Certificate certificate, CertificateRequestDTO dto) {
        certificate.setName(dto.getName());
        certificate.setCertificateNo(dto.getCertificateNo());
        certificate.setTakenFrom(dto.getTakenFrom());
        certificate.setTakenDate(dto.getTakenDate());
        return certificate;
    }

    @Override
    public List<Certificate> dtoListToEntityList(List<CertificateDTO> certificateDTOS) {
        List<Certificate> certificateList = new ArrayList<>();
        for (CertificateDTO certificateDTO : certificateDTOS) {
            Certificate certificate = dtoToEntity(certificateDTO);
            certificateList.add(certificate);
        }
        return certificateList;
    }

    @Override
    public List<CertificateDTO> entityListToDTOList(List<Certificate> certificates) {
        List<CertificateDTO> certificateDTOList = new ArrayList<>();
        for (Certificate certificate : certificates) {
            CertificateDTO certificateDTO = entityToDTO(certificate);
            certificateDTOList.add(certificateDTO);
        }
        return certificateDTOList;
    }

    @Override
    public PageDTO<CertificateDTO> pageEntityToPageDTO(Page<Certificate> pageEntity) {
        PageDTO<CertificateDTO> pageDTO = new PageDTO<>();
        List<Certificate> entityList = pageEntity.toList();
        List<CertificateDTO> certificateDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, certificateDTOList);
        return pageDTO;
    }
}
