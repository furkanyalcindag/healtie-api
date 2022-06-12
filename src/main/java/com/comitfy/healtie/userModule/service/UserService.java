package com.comitfy.healtie.userModule.service;

import com.comitfy.healtie.userModule.dto.UserDTO;
import com.comitfy.healtie.userModule.dto.requestDTO.UserRequestDTO;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.mapper.UserMapper;
import com.comitfy.healtie.userModule.repository.UserRepository;
import com.comitfy.healtie.userModule.specification.UserSpecification;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserDTO, UserRequestDTO, User, UserRepository, UserMapper, UserSpecification> {

    @Autowired
    UserSpecification userSpecification;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public UserMapper getMapper() {
        return userMapper;
    }

    @Override
    public UserSpecification getSpecification() {
        return userSpecification;
    }

    public User getUserByEmail(String email) {

        return getRepository().findByEmail(email).get();
    }
}
