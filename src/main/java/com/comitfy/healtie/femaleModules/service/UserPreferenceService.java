package com.comitfy.healtie.femaleModules.service;

import com.comitfy.healtie.femaleModules.dto.UserPreferenceDTO;
import com.comitfy.healtie.femaleModules.dto.requestDTO.UserPreferenceRequestDTO;
import com.comitfy.healtie.femaleModules.entity.UserPreference;
import com.comitfy.healtie.femaleModules.mapper.UserPreferenceMapper;
import com.comitfy.healtie.femaleModules.repository.UserPreferenceRepository;
import com.comitfy.healtie.femaleModules.specification.UserPreferenceSpecification;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceService extends BaseService<UserPreferenceDTO, UserPreferenceRequestDTO, UserPreference, UserPreferenceRepository, UserPreferenceMapper, UserPreferenceSpecification> {

    @Autowired
    UserPreferenceRepository userPreferenceRepository;

    @Autowired
    UserPreferenceMapper userPreferenceMapper;

    @Autowired
    UserPreferenceSpecification userPreferenceSpecification;

    @Override
    public UserPreferenceRepository getRepository() {
        return userPreferenceRepository;
    }

    @Override
    public UserPreferenceMapper getMapper() {
        return userPreferenceMapper;
    }

    @Override
    public UserPreferenceSpecification getSpecification() {
        return userPreferenceSpecification;
    }
}
