package com.example.demo.service;


import com.example.demo.model.Response;



public interface IAdminService {
	
	public Response getCandidateById(int id,String token);
	
	public Response getCandidateByEmail(String email,String token);
	
	public Response getCandidateByPhoneNumber(String phoneNumber,String token);
	

}
