package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.ExperienceDTO;
import com.comitfy.healtie.app.dto.requestDTO.ExperienceRequestDTO;
import com.comitfy.healtie.app.entity.Experience;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExperienceMapper implements BaseMapper<ExperienceDTO, ExperienceRequestDTO, Experience> {
    @Override
    public ExperienceDTO entityToDTO(Experience entity) {
        ExperienceDTO experienceDTO = new ExperienceDTO();
        experienceDTO.setDescription(entity.getDescription());
        experienceDTO.setWorkedPlace(entity.getWorkedPlace());
        experienceDTO.setStartDate(entity.getStartDate());
        experienceDTO.setEndDate(entity.getEndDate());
        experienceDTO.setUuid(entity.getUuid());
        return experienceDTO;
    }

    @Override
    public Experience dtoToEntity(ExperienceDTO dto) {
        Experience experience = new Experience();
        experience.setWorkedPlace(dto.getWorkedPlace());
        experience.setDescription(dto.getDescription());
        experience.setStartDate(dto.getStartDate());
        experience.setEndDate(dto.getEndDate());
        return experience;
    }

    @Override
    public Experience requestDTOToEntity(ExperienceRequestDTO dto) {
        Experience experience = new Experience();
        experience.setWorkedPlace(dto.getWorkedPlace());
        experience.setDescription(dto.getDescription());
        experience.setStartDate(dto.getStartDate());
        experience.setEndDate(dto.getEndDate());
        return experience;
    }

    @Override
    public Experience requestDTOToExistEntity(Experience experience, ExperienceRequestDTO dto) {
        experience.setWorkedPlace(dto.getWorkedPlace());
        experience.setDescription(dto.getDescription());
        experience.setStartDate(dto.getStartDate());
        experience.setEndDate(dto.getEndDate());
        return experience;
    }

    @Override
    public List<Experience> dtoListToEntityList(List<ExperienceDTO> experienceDTOS) {
        List<Experience> experienceList = new ArrayList<>();
        for (ExperienceDTO experienceDTO : experienceDTOS) {
            Experience experience = dtoToEntity(experienceDTO);
            experienceList.add(experience);
        }
        return experienceList;
    }

    @Override
    public List<ExperienceDTO> entityListToDTOList(List<Experience> experiences) {
        List<ExperienceDTO> experienceDTOList = new ArrayList<>();
        for (Experience experience : experiences) {
            ExperienceDTO experienceDTO = entityToDTO(experience);
            experienceDTOList.add(experienceDTO);
        }
        return experienceDTOList;
    }

    @Override
    public PageDTO<ExperienceDTO> pageEntityToPageDTO(Page<Experience> pageEntity) {
        PageDTO<ExperienceDTO> pageDTO = new PageDTO<ExperienceDTO>();
        List<Experience> entityList = pageEntity.toList();
        List<ExperienceDTO> experienceDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, experienceDTOList);

        return pageDTO;
    }
}
