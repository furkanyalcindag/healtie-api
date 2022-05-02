package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.AcademicInfoDTO;
import com.comitfy.healtie.app.dto.requestDTO.AcademicInfoRequestDTO;
import com.comitfy.healtie.app.entity.AcademicInfo;
import com.comitfy.healtie.app.mapper.AcademicInfoMapper;
import com.comitfy.healtie.app.repository.AcademicInfoRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicInfoService extends BaseService<AcademicInfoDTO, AcademicInfoRequestDTO, AcademicInfo, AcademicInfoRepository, AcademicInfoMapper> {

    @Autowired
    AcademicInfoRepository academicInfoRepository;

    @Autowired
    AcademicInfoMapper academicInfoMapper;

    @Override
    public AcademicInfoRepository getRepository() {
        return academicInfoRepository;
    }

    @Override
    public AcademicInfoMapper getMapper() {
        return academicInfoMapper;
    }
}
