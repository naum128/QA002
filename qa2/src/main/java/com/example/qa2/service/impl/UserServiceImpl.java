package com.example.qa2.service.impl;


import com.example.qa2.entity.User;
import com.example.qa2.repository.UserRepository;
import com.example.qa2.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public User createUser(String name){
		User user = new User();
		user.setName(name);
		return userRepository.save(user);
	}

	public List<User> getAllUser(){
		return userRepository.findAll();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
	}
	@Override
	public User updateUser(Long id, String newName) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

		user.setName(newName);
		return userRepository.save(user);
	}
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}