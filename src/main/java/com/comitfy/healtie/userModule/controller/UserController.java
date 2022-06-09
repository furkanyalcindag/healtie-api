package com.comitfy.healtie.userModule.controller;

import com.comitfy.healtie.userModule.dto.UserDTO;
import com.comitfy.healtie.userModule.dto.requestDTO.UserRequestDTO;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.mapper.UserMapper;
import com.comitfy.healtie.userModule.repository.UserRepository;
import com.comitfy.healtie.userModule.service.UserService;
import com.comitfy.healtie.userModule.specification.UserSpecification;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-api")
public class UserController extends BaseCrudController<UserDTO, UserRequestDTO, User, UserRepository, UserMapper, UserSpecification, UserService> {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Override
    protected UserService getService() {
        return userService;
    }

    @Override
    protected UserMapper getMapper() {
        return userMapper;
    }
}
