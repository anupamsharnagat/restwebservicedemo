package com.anu.demo.restwebservice.restwebservicedemo.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class UserJPAResource {
	
	//@Autowired
	//private UserDaoService userdaoService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;

	// Retrieve all users
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAll()
	{
		return userRepo.findAll();
	}
	
	//Retrieve specific user
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id)
	{
		Optional<User> user= userRepo.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id=>"+id);
		
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAll());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	//Delete specific user
	
	//Retrieve specific user
		@DeleteMapping("/jpa/users/{id}")
		public void deleteUser(@PathVariable int id)
		{
			 userRepo.deleteById(id);
			
			
		}
		
	
	//create user
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		User savedUser = userRepo.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().
		path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//Retrieve post for an id
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllPostsforid(@PathVariable int id)
	{
		Optional<User> users=userRepo.findById(id);
		
		if(!users.isPresent())
		{
			throw new UserNotFoundException("id:--"+id);
		}
		
		return users.get().getPosts();
	}
	
	//create user
		@PostMapping("/jpa/users/{id}/posts")
		public ResponseEntity<Object> createPost(@PathVariable int id,@RequestBody Post post)
		{
			Optional<User> users=userRepo.findById(id);
			
			User user=users.get();
			
			post.setUser(user);
			postRepo.save(post);
			
			if(!users.isPresent())
			{
				throw new UserNotFoundException("id:--"+id);
			}
			
			User savedUser = userRepo.save(user);
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().
			path("/{id}").buildAndExpand(post.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		}
	
}
