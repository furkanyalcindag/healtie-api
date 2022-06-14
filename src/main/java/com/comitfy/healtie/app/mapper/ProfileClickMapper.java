package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.ProfileClickDTO;
import com.comitfy.healtie.app.dto.requestDTO.ProfileClickRequestDTO;
import com.comitfy.healtie.app.entity.ProfileClick;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;

import java.util.List;

public class ProfileClickMapper implements BaseMapper<ProfileClickDTO, ProfileClickRequestDTO, ProfileClick> {
    @Override
    public ProfileClickDTO entityToDTO(ProfileClick entity) {
        return null;
    }

    @Override
    public ProfileClick dtoToEntity(ProfileClickDTO dto) {
        return null;
    }

    @Override
    public ProfileClick requestDTOToEntity(ProfileClickRequestDTO dto) {
        return null;
    }

    @Override
    public ProfileClick requestDTOToExistEntity(ProfileClick entity, ProfileClickRequestDTO dto) {
        return null;
    }

    @Override
    public List<ProfileClick> dtoListToEntityList(List<ProfileClickDTO> profileClickDTOS) {
        return null;
    }

    @Override
    public List<ProfileClickDTO> entityListToDTOList(List<ProfileClick> profileClicks) {
        return null;
    }

    @Override
    public PageDTO<ProfileClickDTO> pageEntityToPageDTO(Page<ProfileClick> pageEntity) {
        return null;
    }
}
