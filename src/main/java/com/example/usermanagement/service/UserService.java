package com.example.usermanagement.service;

import org.springframework.stereotype.Service;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.exception.UserNotFoundException;
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
		return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
		
	}
	
	public User updateUserById(User user, Long id)
	{
	    User existinguser=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
	    if(existinguser != null) {
	    	existinguser.setName(user.getName());
	    	existinguser.setEmail(user.getEmail());
	    	existinguser.setPhone(user.getPhone());
	    }
		return userRepository.save(existinguser);
	}
	
	public void deleteUserById(Long id)
	{
		User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
		
		userRepository.delete(user);	
	}

}
