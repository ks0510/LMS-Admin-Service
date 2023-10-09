package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exception.UserCandidateException;
import com.example.demo.model.Response;
import com.example.demo.model.UserCandidate;

@Service
public class AdminService implements IAdminService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Response getCandidateById(int id, String token) {
		Response response = new Response();

		try {
			response = restTemplate.getForObject("http://localhost:8081/admin/getuserbyid/{id}/{token}", Response.class,
					id, token);
		} catch (Exception e) {
			throw new UserCandidateException("Access Denied", 404);
		}

		return response;

	}

	@Override
	public Response getCandidateByEmail(String email, String token) {
		Response response = new Response();

		try {
			response = restTemplate.getForObject("http://localhost:8081/admin/getuserbyemail/{email}/{token}",
					Response.class, email, token);
		} catch (Exception e) {
			throw new UserCandidateException("Access Denied", 404);
		}
		return response;
	}

	@Override
	public Response getCandidateByPhoneNumber(String phoneNumber, String token) {
		Response response = new Response();

		try {
			response = restTemplate.getForObject("http://localhost:8081/admin/getuserbyphonenumber/{phoneNumber}",
					Response.class, phoneNumber, token);
		} catch (Exception e) {
			throw new UserCandidateException("Access Denied", 404);
		}
		return response;
	}

}
