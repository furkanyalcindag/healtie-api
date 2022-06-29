package com.comitfy.healtie.femaleModules.mapper;

import com.comitfy.healtie.femaleModules.dto.UserPreferenceDTO;
import com.comitfy.healtie.femaleModules.dto.requestDTO.UserPreferenceRequestDTO;
import com.comitfy.healtie.femaleModules.entity.UserPreference;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserPreferenceMapper implements BaseMapper<UserPreferenceDTO, UserPreferenceRequestDTO, UserPreference> {
    @Override
    public UserPreferenceDTO entityToDTO(UserPreference entity) {
        return null;
    }

    @Override
    public UserPreference dtoToEntity(UserPreferenceDTO dto) {
        return null;
    }

    @Override
    public UserPreference requestDTOToEntity(UserPreferenceRequestDTO dto) {
        return null;
    }

    @Override
    public UserPreference requestDTOToExistEntity(UserPreference entity, UserPreferenceRequestDTO dto) {
        return null;
    }

    @Override
    public List<UserPreference> dtoListToEntityList(List<UserPreferenceDTO> userPreferenceDTOS) {
        return null;
    }

    @Override
    public List<UserPreferenceDTO> entityListToDTOList(List<UserPreference> userPreferences) {
        return null;
    }

    @Override
    public PageDTO<UserPreferenceDTO> pageEntityToPageDTO(Page<UserPreference> pageEntity) {
        return null;
    }
}
