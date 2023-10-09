package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Response;
import com.example.demo.model.UserCandidate;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/useradmin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/getcandidatebyId")
	public Response getCandidateById(@RequestParam int id,@RequestHeader String token){
		return adminService.getCandidateById(id,token);
	}
	
	@GetMapping("/getcandidatebyEmail")
	public Response getCandidateByEmail(@RequestParam String email,@RequestHeader String token){
		return adminService.getCandidateByEmail(email,token);
	}
	
	@GetMapping("/getcandidatebyPhoneNumber")
	public Response getCandidateByPhoneNumber(@RequestParam String phoneNumber,@RequestHeader String token){
		return adminService.getCandidateByPhoneNumber(phoneNumber,token);
	}

	
}
