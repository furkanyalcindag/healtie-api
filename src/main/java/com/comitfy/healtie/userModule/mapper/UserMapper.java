package com.comitfy.healtie.userModule.mapper;

import com.comitfy.healtie.app.service.UserInfoService;
import com.comitfy.healtie.userModule.dto.UserDTO;
import com.comitfy.healtie.userModule.dto.requestDTO.UserRequestDTO;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements BaseMapper<UserDTO, UserRequestDTO, User> {

    @Autowired
    UserInfoService userService;

    @Override
    public UserDTO entityToDTO(User entity) {

        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(entity.getFirstName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setEmail(entity.getEmail());
        userDTO.setPhotoLink(entity.getPhotoLink());
        userDTO.setUuid(entity.getUuid());
        userDTO.setLikedCount(userService.getLikeCountByUser(entity.getUuid()));
        userDTO.setSavedCount(userService.getSaveCountByUser(entity.getUuid()));

        return userDTO;
    }

    @Override
    public User dtoToEntity(UserDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPhotoLink(dto.getPhotoLink());
        return user;

    }

    @Override
    public User requestDTOToEntity(UserRequestDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        //user.setPhotoLink(dto.getPhotoLink());

        return user;
    }

    @Override
    public User requestDTOToExistEntity(User user, UserRequestDTO dto) {

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        //user.setPhotoLink(dto.getPhotoLink());
        return user;
    }

    @Override
    public List<User> dtoListToEntityList(List<UserDTO> userDTOS) {
        List<User> userList = new ArrayList<>();
        for (UserDTO userDTO : userDTOS) {
            User user = dtoToEntity(userDTO);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<UserDTO> entityListToDTOList(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = entityToDTO(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public PageDTO<UserDTO> pageEntityToPageDTO(Page<User> pageEntity) {
        PageDTO<UserDTO> pageDTO = new PageDTO<UserDTO>();
        List<User> entityList = pageEntity.toList();
        List<UserDTO> userDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, userDTOList);

        return pageDTO;
    }
}
