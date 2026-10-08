package com.example.usermanagement.service;

import org.springframework.stereotype.Service;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(User user) {

		return userRepository.save(user);

	}
	
	public User getUserById(Long id)
	{
		return userRepository.findById(id).orElse(null);
		
	}

}
