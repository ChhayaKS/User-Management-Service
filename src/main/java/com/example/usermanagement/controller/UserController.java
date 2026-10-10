package com.example.usermanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
	}
	
//	@PostMapping
//	public User createUser(@RequestBody  User user)
//	{
//		return userService.createUser(user);	
//	}
	
	@PostMapping
	public User createUser(@Valid @RequestBody  UserDTO userDTO)
	{
		User newUser = new User();
	    newUser.setName(userDTO.getName());
	    newUser.setEmail(userDTO.getEmail());
	    newUser.setPhone(userDTO.getPhone());
		return userService.createUser(newUser);	
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id)
	{
		return userService.getUserById(id);
	}
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
		
	}
	
	
//	@PutMapping("/{id}")
//	public User updateUserById(@RequestBody User user , @PathVariable Long id)
//	{
//		return userService.updateUserById(user, id);	
//	}
	
	@PutMapping("/{id}")
	public User updateUserById( @Valid @RequestBody UserDTO userDTO , @PathVariable Long id)
	{
		User newUser = new User();
	    newUser.setName(userDTO.getName());
	    newUser.setEmail(userDTO.getEmail());
	    newUser.setPhone(userDTO.getPhone());
		return userService.updateUserById(newUser, id);	
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id)
	{
		userService.deleteUserById(id);
	}
	
}
