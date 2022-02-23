package com.comitfy.healtie.controller;

import com.comitfy.healtie.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import com.comitfy.healtie.entity.User;
import com.comitfy.healtie.model.requestModel.auth.LoginRequest;
import com.comitfy.healtie.model.requestModel.auth.RegisterRequest;
import com.comitfy.healtie.repository.UserRepository;
import com.comitfy.healtie.security.JWTUtil;
import com.comitfy.healtie.service.auth.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private RegisterService userService;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ResponseEntity<String> registerHandler(@RequestBody RegisterRequest user) {


			userService.registerUser(user);

			return new ResponseEntity<String>("Kullanıcı Eklendi", HttpStatus.OK);

	}

	@PostMapping("/login")
	public Map<String, Object> loginHandler(@RequestBody LoginRequest body) {
		try {
			UsernamePasswordAuthenticationToken authInputToken =
					new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

			authManager.authenticate(authInputToken);

			String token = jwtUtil.generateToken(body.getEmail());

			return Collections.singletonMap("jwt-token", token);
		}
		catch (AuthenticationException authExc) {
			throw new RuntimeException("Invalid Login Credentials");
		}
	}

}