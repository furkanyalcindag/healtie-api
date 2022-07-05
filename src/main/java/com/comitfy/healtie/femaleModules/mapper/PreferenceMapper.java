package com.comitfy.healtie.femaleModules.mapper;

import com.comitfy.healtie.femaleModules.dto.PreferenceDTO;
import com.comitfy.healtie.femaleModules.dto.requestDTO.PreferenceRequestDTO;
import com.comitfy.healtie.femaleModules.entity.Preference;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PreferenceMapper implements BaseMapper<PreferenceDTO, PreferenceRequestDTO, Preference> {
    @Override
    public PreferenceDTO entityToDTO(Preference entity) {
        PreferenceDTO preferenceDTO = new PreferenceDTO();
        preferenceDTO.setExpectedNumberOfDay(entity.getExpectedNumberOfDay());
        preferenceDTO.setUuid(entity.getUuid());
        return preferenceDTO;
    }

    @Override
    public Preference dtoToEntity(PreferenceDTO dto) {
        Preference preference = new Preference();
        preference.setExpectedNumberOfDay(dto.getExpectedNumberOfDay());
        return preference;
    }

    @Override
    public Preference requestDTOToEntity(PreferenceRequestDTO dto) {
        Preference preference = new Preference();
        preference.setExpectedNumberOfDay(dto.getExpectedNumberOfDay());
        return preference;
    }

    @Override
    public Preference requestDTOToExistEntity(Preference preference, PreferenceRequestDTO dto) {

        preference.setExpectedNumberOfDay(dto.getExpectedNumberOfDay());
        return preference;
    }

    @Override
    public List<Preference> dtoListToEntityList(List<PreferenceDTO> preferenceDTOS) {
        List<Preference> preferenceList = new ArrayList<>();
        for (PreferenceDTO preferenceDTO : preferenceDTOS) {
            Preference preference = dtoToEntity(preferenceDTO);
            preferenceList.add(preference);
        }
        return preferenceList;
    }

    @Override
    public List<PreferenceDTO> entityListToDTOList(List<Preference> preferences) {
        List<PreferenceDTO> preferenceDTOList = new ArrayList<>();
        for (Preference preference : preferences) {
            PreferenceDTO preferenceDTO = entityToDTO(preference);
            preferenceDTOList.add(preferenceDTO);
        }
        return preferenceDTOList;
    }

    @Override
    public PageDTO<PreferenceDTO> pageEntityToPageDTO(Page<Preference> pageEntity) {
        PageDTO<PreferenceDTO> pageDTO = new PageDTO<PreferenceDTO>();
        List<Preference> entityList = pageEntity.toList();
        List<PreferenceDTO> preferenceDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, preferenceDTOList);
        return pageDTO;
    }
}
