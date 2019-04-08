package com.anu.demo.restwebservice.restwebservicedemo.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User user= userdaoService.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id=>"+id);
		return user;
	}
	
	//Delete specific user
	
	//Retrieve specific user
		@DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable int id)
		{
			User user= userdaoService.deleteUser(id);
			if(user==null)
				throw new UserNotFoundException("id=>"+id);
			
		}
		
	
	//create user
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		User savedUser = userdaoService.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().
		path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
