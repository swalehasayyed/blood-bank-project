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

import com.backend.model.Donor;
import com.backend.model.User;
import com.backend.service.DonorService;
import com.backend.service.UserService;


	@RestController
	@RequestMapping("/donors")
	public class DonorController {
		@Autowired
		private DonorService service;
		// Get all Donor
	    @GetMapping
	    public List<Donor> getAllDonors() {
	        return service.getAllDonors();
	    }

	    // Get aDonorby ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Donor> getUserById(@PathVariable int id) {
	        Optional<Donor> donor = service.getDonorById(id);
	        return donor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	    //Create New Donor
		@PostMapping
		public Donor addDonor(@RequestBody Donor donor) {
			return service.addDonor(donor);
		}
		 // Update an existing Donor
	    @PutMapping("/{id}")
	    public ResponseEntity<Donor> updateDonor(@PathVariable int id, @RequestBody Donor donor) {
	        Donor updatedDonor = service.updateDonor(id, donor);
	        return updatedDonor != null ? ResponseEntity.ok(updatedDonor) : ResponseEntity.notFound().build();
	    }

	    // Delete a Donor
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDonor(@PathVariable int id) {
	        return service.deleteDonor(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	    }

	}



