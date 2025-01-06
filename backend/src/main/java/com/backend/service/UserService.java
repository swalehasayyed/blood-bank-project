package com.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.User;
import com.backend.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	//Create new user
	public User addUser(User user) {
		return repo.save(user);
	}
	public List<User>getAllUsers(){
		return repo.findAll();
		
	}
	//Get user by id
	public Optional<User>getUserById(int id){
		return repo.findById(id);
		
	}
	//Update existing user
	public User updateUser(int id,User user) {
		if(repo.existsById(id)) {
			user.setId(id);
			return repo.save(user);
		}
		return null;
		}
	//Delete User
	public boolean deleteUser(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
		
	}
	
	public User findByEmail(String username) {
		return repo.findByEmail(username);
	}


}
