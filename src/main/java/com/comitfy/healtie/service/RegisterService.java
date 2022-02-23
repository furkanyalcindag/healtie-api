package com.comitfy.healtie.service;

import com.comitfy.healtie.entity.User;
import com.comitfy.healtie.model.requestModel.auth.RegisterRequest;
import com.comitfy.healtie.repository.RoleRepository;
import com.comitfy.healtie.repository.UserRepository;
import com.comitfy.healtie.service.interfaces.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService implements IRegisterService {


    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean registerUser(RegisterRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());


        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(request.getEmail());
            newUser.setPassword(passwordEncoder.encode(request.getPassword()));
            newUser.setName(request.getFirstName());
            newUser.setSurname(request.getLastName());

            newUser.getRoles().add(roleRepository.findByName("user"));

            userRepository.save(newUser);
            return true;

        }
        else {


            throw new ResourceNotFoundException("email is exist = " + request.getEmail());

        }

    }
}
