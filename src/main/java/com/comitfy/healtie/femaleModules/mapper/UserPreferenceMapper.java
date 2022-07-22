package com.comitfy.healtie.femaleModules.mapper;

import com.comitfy.healtie.femaleModules.dto.UserPreferenceDTO;
import com.comitfy.healtie.femaleModules.dto.requestDTO.UserPreferenceRequestDTO;
import com.comitfy.healtie.femaleModules.entity.UserPreference;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserPreferenceMapper implements BaseMapper<UserPreferenceDTO, UserPreferenceRequestDTO, UserPreference> {
    @Override
    public UserPreferenceDTO entityToDTO(UserPreference entity) {
        UserPreferenceDTO userPreferenceDTO = new UserPreferenceDTO();
        userPreferenceDTO.setPreferenceUUID(entity.getPreferenceUUID());
        userPreferenceDTO.setUserUUID(entity.getUserUUID());
        userPreferenceDTO.setUuid(entity.getUuid());
        return userPreferenceDTO;

    }

    @Override
    public UserPreference dtoToEntity(UserPreferenceDTO dto) {
        UserPreference userPreference = new UserPreference();
        userPreference.setUserUUID(dto.getUserUUID());
        userPreference.setPreferenceUUID(dto.getPreferenceUUID());
        return userPreference;
    }

    @Override
    public UserPreference requestDTOToEntity(UserPreferenceRequestDTO dto) {
        UserPreference userPreference = new UserPreference();
        userPreference.setUserUUID(dto.getUserUUID());
        userPreference.setPreferenceUUID(dto.getPreferenceUUID());
        return userPreference;
    }

    @Override
    public UserPreference requestDTOToExistEntity(UserPreference userPreference, UserPreferenceRequestDTO dto) {

        userPreference.setUserUUID(dto.getUserUUID());
        userPreference.setPreferenceUUID(dto.getPreferenceUUID());
        return userPreference;
    }

    @Override
    public List<UserPreference> dtoListToEntityList(List<UserPreferenceDTO> userPreferenceDTOS) {
        List<UserPreference> userPreferenceList = new ArrayList<>();
        for (UserPreferenceDTO userPreferenceDTO : userPreferenceDTOS) {
            UserPreference userPreference = dtoToEntity(userPreferenceDTO);
            userPreferenceList.add(userPreference);
        }
        return userPreferenceList;
    }

    @Override
    public List<UserPreferenceDTO> entityListToDTOList(List<UserPreference> userPreferences) {
        List<UserPreferenceDTO> userPreferenceDTOList = new ArrayList<>();
        for (UserPreference userPreference : userPreferences) {
            UserPreferenceDTO userPreferenceDTO = entityToDTO(userPreference);
            userPreferenceDTOList.add(userPreferenceDTO);
        }
        return userPreferenceDTOList;
    }

    @Override
    public PageDTO<UserPreferenceDTO> pageEntityToPageDTO(Page<UserPreference> pageEntity) {
        PageDTO<UserPreferenceDTO> pageDTO = new PageDTO<UserPreferenceDTO>();
        List<UserPreference> entityList = pageEntity.toList();
        List<UserPreferenceDTO> userPreferenceDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, userPreferenceDTOList);
        return pageDTO;
    }
}
