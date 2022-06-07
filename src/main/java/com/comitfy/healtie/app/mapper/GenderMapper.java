package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.GenderDTO;
import com.comitfy.healtie.app.dto.requestDTO.GenderRequestDTO;
import com.comitfy.healtie.app.entity.Gender;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenderMapper implements BaseMapper<GenderDTO, GenderRequestDTO, Gender> {

    @Override
    public GenderDTO entityToDTO(Gender entity) {
        GenderDTO genderDTO = new GenderDTO();
        genderDTO.setGender(entity.getGender());
        genderDTO.setUuid(entity.getUuid());
        return genderDTO;
    }

    @Override
    public Gender dtoToEntity(GenderDTO dto) {
        Gender gender = new Gender();
        gender.setGender(dto.getGender());
        return gender;
    }

    @Override
    public Gender requestDTOToEntity(GenderRequestDTO dto) {
        Gender gender = new Gender();
        gender.setGender(dto.getGender());
        return gender;
    }

    @Override
    public Gender requestDTOToExistEntity(Gender gender, GenderRequestDTO dto) {
        gender.setGender(dto.getGender());
        return gender;
    }

    @Override
    public List<Gender> dtoListToEntityList(List<GenderDTO> genderDTOS) {
        List<Gender> genderList = new ArrayList<>();
        for (GenderDTO genderDTO : genderDTOS) {
            Gender gender = dtoToEntity(genderDTO);
            genderList.add(gender);
        }
        return genderList;
    }

    @Override
    public List<GenderDTO> entityListToDTOList(List<Gender> genders) {
        List<GenderDTO> genderDTOList = new ArrayList<>();
        for (Gender gender : genders) {
            GenderDTO genderDTO = entityToDTO(gender);
            genderDTOList.add(genderDTO);
        }
        return genderDTOList;
    }

    @Override
    public PageDTO<GenderDTO> pageEntityToPageDTO(Page<Gender> pageEntity) {
        PageDTO<GenderDTO> pageDTO = new PageDTO<GenderDTO>();
        List<Gender> entityList = pageEntity.toList();
        List<GenderDTO> genderDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, genderDTOList);

        return pageDTO;
    }
}
