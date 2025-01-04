package com.example.jobportal.controller;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;
import com.jobportal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobPortalController {

    // Logger for the controller
    private static final Logger logger = LoggerFactory.getLogger(JobPortalController.class);

    @Autowired
    private UserRepository userRepository; // Inject UserRepository for DB operations

    private UserService userService;  // Inject the UserService

    // GetMapping for homepage
    @GetMapping("/")
    public String index() {
        return "index"; // Refers to index.jsp
    }

    // GetMapping for login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Refers to login.jsp
    }

    // PostMapping for login handling
    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        logger.info("Attempting login for user: {}", username);

        // Find user by username
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            logger.info("Login successful for user: {}", username);
            return "home"; // Redirect to homepage
        } else {
            logger.warn("Login failed for user: {}", username);
            model.addAttribute("error", "Invalid credentials");
            return "login"; // Stay on login page with error
        }
    }

    // GetMapping for register page
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register"; // Refers to register.jsp
    }

    // PostMapping for registration handling
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        logger.info("Registering new user: {}", user.getUsername());

        try {
            // Check if the username already exists
            if (userRepository.findByUsername(user.getUsername()) != null) {
                logger.warn("Username already exists: {}", user.getUsername());
                model.addAttribute("error", "Username already taken.");
                return "register"; // Stay on register page
            }

            // Save the new user to the database
            userRepository.save(user);
            logger.info("User registered successfully: {}", user.getUsername());
            model.addAttribute("message", "Registration successful! Please login.");
            return "login"; // Redirect to login page
        } catch (Exception e) {
            logger.error("An error occurred during registration: {}", e.getMessage(), e);
            model.addAttribute("error", "An error occurred during registration.");
            return "register"; // Stay on register page with error
        }
    }
}
