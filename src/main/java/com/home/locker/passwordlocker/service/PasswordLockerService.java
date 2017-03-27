package com.home.locker.passwordlocker.service;

import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.locker.passwordlocker.request.PasswordLockerRequest;
import com.home.locker.passwordlocker.response.PasswordLockerResponse;

@Component
@RestController
@RequestMapping("/passwordlocker")
public class PasswordLockerService {
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "Service is up and running";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, 
			produces = MediaType.APPLICATION_JSON)
	public PasswordLockerResponse savePasswordDetails(@RequestBody PasswordLockerRequest passwordLockerRequest) {
		System.out.println("username:" + passwordLockerRequest.getUsername());
		System.out.println("password:" + passwordLockerRequest.getPassword());
		PasswordLockerResponse passwordLockerResponse = new PasswordLockerResponse();
		passwordLockerResponse.setUsername(passwordLockerRequest.getUsername());
		passwordLockerResponse.setPassword(passwordLockerRequest.getPassword());
		return passwordLockerResponse;
	}
}
