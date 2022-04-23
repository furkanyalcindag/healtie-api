package com.comitfy.healtie.userModule.service;

import com.comitfy.healtie.userModule.dto.RoleDTO;
import com.comitfy.healtie.userModule.entity.Role;
import com.comitfy.healtie.userModule.mapper.RoleMapper;
import com.comitfy.healtie.userModule.repository.RoleRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<RoleDTO, Role, RoleRepository, RoleMapper> {


    @Autowired
    RoleRepository repository;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public RoleRepository getRepository() {
        return repository;
    }

    @Override
    public RoleMapper getMapper() {
        return roleMapper;
    }
}
