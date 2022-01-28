package com.comitfy.healtie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DenemeController {
	@RequestMapping(path = "/deneme", method = RequestMethod.GET)
	public String deneme() {
		return "Hello World";
	}
}
