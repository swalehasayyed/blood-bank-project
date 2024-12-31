package com.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.User;
import com.backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	// Get all teachers
    @GetMapping
    public List<User> getAllTeachers() {
        return service.getAllUsers();
    }

    // Get a teacher by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getTeacherById(@PathVariable int id) {
        Optional<User> teacher = service.getUserById(id);
        return teacher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	@PostMapping
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	 // Update an existing teacher
    @PutMapping("/{id}")
    public ResponseEntity<User> updateTeacher(@PathVariable int id, @RequestBody User user) {
        User updatedUser = service.updateUser(id, user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    // Delete a teacher
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        return service.deleteUser(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
