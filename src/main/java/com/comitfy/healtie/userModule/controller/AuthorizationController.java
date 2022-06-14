package com.comitfy.healtie.userModule.controller;


import com.comitfy.healtie.userModule.entity.Role;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.model.requestModel.auth.LoginRequest;
import com.comitfy.healtie.userModule.model.requestModel.auth.RegisterRequest;
import com.comitfy.healtie.userModule.service.RoleService;
import com.comitfy.healtie.userModule.service.UserService;
import com.comitfy.healtie.userModule.service.interfaces.IAuthService;
import com.comitfy.healtie.userModule.service.interfaces.IUserService;
import com.comitfy.healtie.util.common.HelperService;
import com.comitfy.healtie.util.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthorizationController {

    @Autowired
    IAuthService authService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    HelperService helperService;

    @Autowired
    UserService userService;



    @PostMapping("/register")
    public ResponseEntity<String> registerHandler(@RequestBody RegisterRequest user) {


        authService.registerUser(user);

        return new ResponseEntity<String>("Kullanıcı Eklendi", HttpStatus.OK);

    }

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody LoginRequest body) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

        authManager.authenticate(authInputToken);

        String token = jwtUtil.generateToken(body.getEmail());

        StringBuilder roles = new StringBuilder();
        User user = userService.getUserByEmail(body.getEmail());
        //List<Role> roleList = authService.getRolesByUser(user);
        for (Role role : user.getRoles()) {

            if (roles.toString().equals("")) {
                roles.append(role.getName());
            } else {
                roles.append(",").append(role.getName());
            }
        }

        Map<String, Object> authorizationMap = new HashMap<>();
        authorizationMap.put("roles", roles);
        authorizationMap.put("jwt-token", token);
        authorizationMap.put("gender",user.getGenderEnum()!=null?user.getGenderEnum().name():"");
        //Collections.singletonMap("jwt-token", token);

        return authorizationMap;
    }
}
