package com.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String username);

}
