package com.comitfy.healtie.model.requestModel.auth;

import lombok.Data;

@Data
public class RegisterRequest {

	private String email;
	private String password;
	private String firstName;
	private String lastName;


}
