package com.comitfy.healtie.userModule.mapper;

import com.comitfy.healtie.userModule.dto.RoleDTO;
import com.comitfy.healtie.userModule.entity.Role;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper implements BaseMapper<RoleDTO, Role> {
    @Override
    public RoleDTO entityToDTO(Role entity) {
        return null;
    }

    @Override
    public Role dtoToEntity(RoleDTO dto) {
        return null;
    }

    @Override
    public List<Role> dtoListToEntityList(List<RoleDTO> roleDTOS) {
        return null;
    }

    @Override
    public List<RoleDTO> entityListToDTOList(List<Role> roles) {

        List<RoleDTO> roleDTOList = new ArrayList<>();

        for (Role role:roles){
            RoleDTO roleDTO = new RoleDTO();

            BeanUtils.copyProperties(role,roleDTO);

            roleDTOList.add(roleDTO);

        }

        return roleDTOList;
    }
}
