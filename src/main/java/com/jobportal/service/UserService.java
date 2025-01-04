package com.jobportal.service;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;  // Inject the UserRepository

    // Save a new user to the database
    public User saveUser(User user) {
        return userRepository.save(user);  // Save the user entity to the DB
    }

    // Find a user by username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);  // Find the user by username
    }

    // Check if a user exists by username
    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;  // Return true if user exists
    }
}
