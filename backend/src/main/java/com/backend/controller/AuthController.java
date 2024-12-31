package com.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.User;
import com.backend.service.UserService;

@RestController
@RequestMapping("/")
public class AuthController {
	@Autowired
	private UserService service;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Map<String, String> loginData) {
		String userName = loginData.get("username");
		String password = loginData.get("password");
		User user = service.findByUsername(userName);

		if (user != null && user.getPassword() == password) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "username or password is wrong"));
	}

}
