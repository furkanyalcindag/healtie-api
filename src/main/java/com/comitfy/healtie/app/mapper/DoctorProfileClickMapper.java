package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.DoctorProfileClickDTO;
import com.comitfy.healtie.app.dto.requestDTO.DoctorProfileClickRequestDTO;
import com.comitfy.healtie.app.entity.DoctorProfileClick;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorProfileClickMapper implements BaseMapper<DoctorProfileClickDTO, DoctorProfileClickRequestDTO, DoctorProfileClick> {
    @Override
    public DoctorProfileClickDTO entityToDTO(DoctorProfileClick entity) {

        DoctorProfileClickDTO doctorProfileClickDTO = new DoctorProfileClickDTO();
        doctorProfileClickDTO.setDoctorUUID(entity.getDoctorUuid());
        doctorProfileClickDTO.setUserUUID(entity.getUserUuid());
        doctorProfileClickDTO.setUuid(entity.getUuid());
        return doctorProfileClickDTO;
    }

    @Override
    public DoctorProfileClick dtoToEntity(DoctorProfileClickDTO dto) {
        DoctorProfileClick doctorProfileClick = new DoctorProfileClick();
        doctorProfileClick.setDoctorUuid(dto.getDoctorUUID());
        doctorProfileClick.setUserUuid(dto.getUserUUID());
        return doctorProfileClick;
    }

    @Override
    public DoctorProfileClick requestDTOToEntity(DoctorProfileClickRequestDTO dto) {
        DoctorProfileClick doctorProfileClick = new DoctorProfileClick();
        doctorProfileClick.setDoctorUuid(dto.getDoctorUUID());
        doctorProfileClick.setUserUuid(dto.getUserUUID());
        return doctorProfileClick;
    }

    @Override
    public DoctorProfileClick requestDTOToExistEntity(DoctorProfileClick doctorProfileClick, DoctorProfileClickRequestDTO dto) {

        doctorProfileClick.setDoctorUuid(dto.getDoctorUUID());
        doctorProfileClick.setUserUuid(dto.getUserUUID());
        return doctorProfileClick;
    }

    @Override
    public List<DoctorProfileClick> dtoListToEntityList(List<DoctorProfileClickDTO> profileClickDTOS) {
        List<DoctorProfileClick> doctorProfileClickList = new ArrayList<>();
        for (DoctorProfileClickDTO doctorProfileClickDTO : profileClickDTOS) {
            DoctorProfileClick doctorProfileClick = dtoToEntity(doctorProfileClickDTO);
            doctorProfileClickList.add(doctorProfileClick);
        }
        return doctorProfileClickList;
    }

    @Override
    public List<DoctorProfileClickDTO> entityListToDTOList(List<DoctorProfileClick> profileClicks) {
        List<DoctorProfileClickDTO> doctorProfileClickDTOList = new ArrayList<>();
        for (DoctorProfileClick doctorProfileClick : profileClicks) {
            DoctorProfileClickDTO doctorProfileClickDTO = entityToDTO(doctorProfileClick);
            doctorProfileClickDTOList.add(doctorProfileClickDTO);
        }
        return doctorProfileClickDTOList;
    }

    @Override
    public PageDTO<DoctorProfileClickDTO> pageEntityToPageDTO(Page<DoctorProfileClick> pageEntity) {
        PageDTO<DoctorProfileClickDTO> pageDTO = new PageDTO<DoctorProfileClickDTO>();
        List<DoctorProfileClick> entityList = pageEntity.toList();
        List<DoctorProfileClickDTO> doctorProfileClickDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, doctorProfileClickDTOList);
        return pageDTO;
    }
}

