package com.rky.restfulwebservice.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rky.restfulwebservice.beans.User;
import com.rky.restfulwebservice.beans.services.UserServices;
import com.rky.restfulwebservice.exception.UserNotFoundException;

@RestController
public class UserController {
	
	private UserServices userServices;

	
	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}

	//Retrieve all the users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userServices.findAll();
		
	}
	
	//Retrieve a user
	@GetMapping("/users/{id}")
	public Resource<User> getUser(@PathVariable String id) {
		User user = userServices.findOne(Integer.parseInt(id));
		if(user == null) {
			throw new UserNotFoundException("id : "+id);
		}
		
		//############### HEATEOS ################
		//Retrieve all the users
		Resource<User> resource = new Resource<User>(user);
		
		//Create the link for all the users
		ControllerLinkBuilder link = ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
		
		resource.add(link.withRel("all-users"));
		
		return resource;
	}
	
	//save a user(post request)
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = userServices.save(user);
		System.out.println(savedUser.toString());
		
		//Send the Created status and the location of the created user as URI
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//delete a user
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable String id) {
		User user = userServices.deleteById(Integer.parseInt(id));
		if(user == null) {
			throw new UserNotFoundException("User not found, so can not detele anything, id : "+id);
		}
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
