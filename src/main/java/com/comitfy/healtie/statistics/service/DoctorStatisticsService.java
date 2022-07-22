package com.comitfy.healtie.statistics.service;

import com.comitfy.healtie.app.dto.DoctorDTO;
import com.comitfy.healtie.app.dto.requestDTO.DoctorRequestDTO;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.DoctorMapper;
import com.comitfy.healtie.app.repository.ArticleRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.specification.DoctorSpecification;
import com.comitfy.healtie.statistics.dto.DoctorStatisticsDTO;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorStatisticsService extends BaseService<DoctorDTO, DoctorRequestDTO, Doctor, DoctorRepository, DoctorMapper, DoctorSpecification> {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DoctorSpecification doctorSpecification;

    @Autowired
    ArticleRepository articleRepository;


    @Override
    public DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    public DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    public DoctorSpecification getSpecification() {
        return doctorSpecification;
    }

    public long getCountOfLikesByDate(UUID userUUID, DoctorStatisticsDTO dto) {
        return doctorRepository.getCountOfArticleLikesByDate(userUUID, dto.getStartDate(), dto.getEndDate());
    }

}
