package com.comitfy.healtie.userModule.service.interfaces;


import com.comitfy.healtie.userModule.entity.Role;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.model.requestModel.auth.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAuthService {


    boolean registerUser(RegisterRequest request);
}
