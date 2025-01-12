package com.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.Request;

public interface RequestRepo extends JpaRepository<Request, Integer> {

}
