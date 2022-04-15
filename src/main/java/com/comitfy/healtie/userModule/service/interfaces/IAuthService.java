package com.comitfy.healtie.userModule.service.interfaces;


import com.comitfy.healtie.userModule.model.requestModel.auth.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface IAuthService {
    boolean registerUser(RegisterRequest request);
}
