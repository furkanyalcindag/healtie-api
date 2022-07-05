package com.comitfy.healtie.femaleModules.service;

import com.comitfy.healtie.femaleModules.dto.PreferenceDTO;
import com.comitfy.healtie.femaleModules.dto.UserPreferenceDTO;
import com.comitfy.healtie.femaleModules.dto.requestDTO.PreferenceRequestDTO;
import com.comitfy.healtie.femaleModules.entity.Preference;
import com.comitfy.healtie.femaleModules.entity.UserPreference;
import com.comitfy.healtie.femaleModules.mapper.PreferenceMapper;
import com.comitfy.healtie.femaleModules.repository.PreferenceRepository;
import com.comitfy.healtie.femaleModules.repository.UserPreferenceRepository;
import com.comitfy.healtie.femaleModules.specification.PreferenceSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.repository.UserRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PreferenceService extends BaseService<PreferenceDTO, PreferenceRequestDTO, Preference, PreferenceRepository, PreferenceMapper, PreferenceSpecification> {

    @Autowired
    PreferenceRepository preferenceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPreferenceRepository userPreferenceRepository;
    @Autowired
    PreferenceMapper preferenceMapper;
    @Autowired
    PreferenceSpecification preferenceSpecification;

    @Override
    public PreferenceRepository getRepository() {
        return preferenceRepository;
    }

    @Override
    public PreferenceMapper getMapper() {
        return preferenceMapper;
    }

    @Override
    public PreferenceSpecification getSpecification() {
        return preferenceSpecification;
    }

    public PreferenceRequestDTO savePreferenceByUser(UUID id, PreferenceRequestDTO dto) {
        Optional<User> user = userRepository.findByUuid(id);
        if (user.isPresent()) {
            Preference preference = getMapper().requestDTOToEntity(dto);
            preferenceRepository.save(preference);


                UserPreference userPreference = new UserPreference();
                userPreference.setPreferenceUUID(preference.getUuid());
                userPreference.setUserUUID(user.get().getUuid());
                userPreferenceRepository.save(userPreference);


            return dto;
        } else {
            return null;
        }
    }


}
