package com.comitfy.healtie.app.service;

import com.comitfy.healtie.userModule.dto.UserDTO;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.mapper.UserMapper;
import com.comitfy.healtie.userModule.repository.UserRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public long getLikeCountByUser(UUID userUUID) {

        return userRepository.getLikeCountByUser(userUUID);
    }


    public long getSaveCountByUser(UUID userUUID) {

        return userRepository.getSaveCountByUser(userUUID);
    }


    public UserDTO findByUUID(UUID uuid) {
        Optional<User> optionalEntity = userRepository.findByUuid(uuid);
        return optionalEntity.map(entity -> userMapper.entityToDTO(entity)).orElse(null);

    }

}
