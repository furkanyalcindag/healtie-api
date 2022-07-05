package com.comitfy.healtie.femaleModules.mapper;

import com.comitfy.healtie.femaleModules.dto.FertilityLevelDTO;
import com.comitfy.healtie.femaleModules.dto.requestDTO.FertilityLevelRequestDTO;
import com.comitfy.healtie.femaleModules.entity.FertilityLevel;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FertilityLevelMapper implements BaseMapper<FertilityLevelDTO, FertilityLevelRequestDTO, FertilityLevel> {

    @Override
    public FertilityLevelDTO entityToDTO(FertilityLevel entity) {
        FertilityLevelDTO fertilityLevelDTO = new FertilityLevelDTO();
        fertilityLevelDTO.setFertilityLevelEnum(entity.getFertilityLevelEnum());
        fertilityLevelDTO.setDate(entity.getDate());
        return fertilityLevelDTO;
    }

    @Override
    public FertilityLevel dtoToEntity(FertilityLevelDTO dto) {
        return null;
    }

    @Override
    public FertilityLevel requestDTOToEntity(FertilityLevelRequestDTO dto) {
        return null;
    }

    @Override
    public FertilityLevel requestDTOToExistEntity(FertilityLevel entity, FertilityLevelRequestDTO dto) {
        return null;
    }

    @Override
    public List<FertilityLevel> dtoListToEntityList(List<FertilityLevelDTO> fertilityLevelDTOS) {
        return null;
    }

    @Override
    public List<FertilityLevelDTO> entityListToDTOList(List<FertilityLevel> fertilityLevels) {
        return null;
    }

    @Override
    public PageDTO<FertilityLevelDTO> pageEntityToPageDTO(Page<FertilityLevel> pageEntity) {
        return null;
    }
}
