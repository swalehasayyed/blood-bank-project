package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.User;
import com.backend.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;

	public User addUser(User user) {
		return repo.save(user);
	}

}
