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

	public User addUser(User user) {
		return repo.save(user);
	}
	public List<User>getAllUsers(){
		return repo.findAll();
		
	}
	//id
	public Optional<User>getUserById(int id){
		return repo.findById(id);
		
	}
	public User updateUser(int id,User user) {
		if(repo.existsById(id)) {
			user.setId(id);
			return repo.save(user);
		}
		return null;
		}
	public boolean deleteUser(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
		
	}


}
