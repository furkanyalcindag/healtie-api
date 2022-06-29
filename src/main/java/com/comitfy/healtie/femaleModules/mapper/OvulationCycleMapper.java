package com.comitfy.healtie.femaleModules.mapper;

import com.comitfy.healtie.femaleModules.dto.OvulationCycleDTO;
import com.comitfy.healtie.femaleModules.dto.requestDTO.OvulationCycleRequestDTO;
import com.comitfy.healtie.femaleModules.entity.OvulationCycle;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OvulationCycleMapper implements BaseMapper<OvulationCycleDTO, OvulationCycleRequestDTO, OvulationCycle> {
    @Override
    public OvulationCycleDTO entityToDTO(OvulationCycle entity) {
        return null;
    }

    @Override
    public OvulationCycle dtoToEntity(OvulationCycleDTO dto) {
        return null;
    }

    @Override
    public OvulationCycle requestDTOToEntity(OvulationCycleRequestDTO dto) {
        return null;
    }

    @Override
    public OvulationCycle requestDTOToExistEntity(OvulationCycle entity, OvulationCycleRequestDTO dto) {
        return null;
    }

    @Override
    public List<OvulationCycle> dtoListToEntityList(List<OvulationCycleDTO> ovulationCycleDTOS) {
        return null;
    }

    @Override
    public List<OvulationCycleDTO> entityListToDTOList(List<OvulationCycle> ovulationCycles) {
        return null;
    }

    @Override
    public PageDTO<OvulationCycleDTO> pageEntityToPageDTO(Page<OvulationCycle> pageEntity) {
        return null;
    }
}
