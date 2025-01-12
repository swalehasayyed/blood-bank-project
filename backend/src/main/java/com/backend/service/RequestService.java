package com.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Request;
import com.backend.repo.RequestRepo;
@Service
public class RequestService {
	@Autowired
	private RequestRepo repo;
	//Create new user
		public Request addRequest(Request request) {
			return repo.save(request);
		}
		public List<Request>getAllRequest(){
			return repo.findAll();
			
		}
		//Get user by id
		public Optional<Request>getRequestById(int rid){
			return repo.findById(rid);
			
		}
		//Update existing user
		public Request updateRequest(int rid,Request request) {
			if(repo.existsById(rid)) {
				request.setRid(rid);
				return repo.save(request);
			}
			return null;
			}
		//Delete User
		public boolean deleteRequest(int rid) {
			if(repo.existsById(rid)) {
				repo.deleteById(rid);
				return true;
			}
			return false;
			
		}


}
