package com.anu.demo.restwebservice.restwebservicedemo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userdaoService;

	// Retrieve all users
	
	@GetMapping("/users")
	public List<User> retrieveAll()
	{
		return userdaoService.findAll();
	}
	
	//Retrieve specific user
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		return userdaoService.findOne(id);
	}
}
