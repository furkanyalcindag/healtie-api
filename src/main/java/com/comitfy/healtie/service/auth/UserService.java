package com.comitfy.healtie.service.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import com.comitfy.healtie.entity.User;
import com.comitfy.healtie.model.requestModel.auth.RegisterRequest;
import com.comitfy.healtie.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	public boolean registerUser(RegisterRequest request) throws Exception {
		Optional<User> user = userRepository.findByEmail(request.getEmail());

		if (user.isEmpty()) {
			User newUser = new User();
			newUser.setEmail(request.getEmail());
			newUser.setPassword(passwordEncoder.encode(request.getPassword()));
			newUser.setName(request.getFirstName());
			newUser.setSurname(request.getLastName());

			userRepository.save(newUser);

			return true;

		}
		else {
			throw new Exception("email is exist = " + request.getEmail());
		}

	}
}
