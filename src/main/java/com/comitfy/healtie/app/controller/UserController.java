package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.service.UserService;
import com.comitfy.healtie.userModule.dto.UserDTO;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-profile")
public class UserController {

    @Autowired
    HelperService helperService;

    @Autowired
    UserService userService;


    @GetMapping("info")
    public ResponseEntity<UserDTO> getUserInfoFromSession() {

        User user = helperService.getUserFromSession();

        UserDTO userDTO = userService.findByUUID(user.getUuid());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
