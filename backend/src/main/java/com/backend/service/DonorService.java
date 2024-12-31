package com.backend.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Donor;
import com.backend.model.User;
import com.backend.repo.DonorRepo;
import com.backend.repo.UserRepo;

@Service
public class DonorService {
	@Autowired
	private DonorRepo repo;
	//Create new user
	public Donor addDonor(Donor donor) {
		return repo.save(donor);
	}
	public List<Donor>getAllDonors(){
		return repo.findAll();
		
	}
	//Get user by id
	public Optional<Donor>getDonorById(int id){
		return repo.findById(id);
		
	}
	//Update existing user
	public Donor updateDonor(int id,Donor donor) {
		if(repo.existsById(id)) {
			donor.setId(id);
			return repo.save(donor);
		}
		return null;
		}
	//Delete User
	public boolean deleteDonor(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
		
	}


}

