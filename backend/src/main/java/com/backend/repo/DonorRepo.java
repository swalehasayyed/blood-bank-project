package com.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.Donor;

public interface DonorRepo extends JpaRepository<Donor, Integer> {

}
