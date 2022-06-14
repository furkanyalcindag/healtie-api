package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.DoctorProfileClickDTO;
import com.comitfy.healtie.app.dto.requestDTO.DoctorProfileClickRequestDTO;
import com.comitfy.healtie.app.dto.requestDTO.ProfileClickRequestDTO;
import com.comitfy.healtie.app.entity.DoctorProfileClick;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorProfileClickMapper implements BaseMapper<DoctorProfileClickDTO, DoctorProfileClickRequestDTO, DoctorProfileClick> {
    @Override
    public DoctorProfileClickDTO entityToDTO(DoctorProfileClick entity) {

        DoctorProfileClickDTO doctorProfileClickDTO = new DoctorProfileClickDTO();
        doctorProfileClickDTO.setDoctorUUID(entity.getDoctorUuid());
        doctorProfileClickDTO.setUserUUID(entity.getUserUuid());
        return doctorProfileClickDTO;
    }

    @Override
    public DoctorProfileClick dtoToEntity(DoctorProfileClickDTO dto) {
        return null;
    }

    @Override
    public DoctorProfileClick requestDTOToEntity(DoctorProfileClickRequestDTO dto) {
        return null;
    }

    @Override
    public DoctorProfileClick requestDTOToExistEntity(DoctorProfileClick entity, DoctorProfileClickRequestDTO dto) {
        return null;
    }

    @Override
    public List<DoctorProfileClick> dtoListToEntityList(List<DoctorProfileClickDTO> profileClickDTOS) {
        return null;
    }

    @Override
    public List<DoctorProfileClickDTO> entityListToDTOList(List<DoctorProfileClick> profileClicks) {
        return null;
    }

    @Override
    public PageDTO<DoctorProfileClickDTO> pageEntityToPageDTO(Page<DoctorProfileClick> pageEntity) {
        return null;
    }
}
