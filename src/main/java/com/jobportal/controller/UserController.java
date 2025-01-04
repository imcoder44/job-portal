package com.jobportal.controller;

import com.jobportal.model.User;
import com.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService; // Inject UserService

    // GetMapping for login page
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Refers to login.jsp
    }

    // GetMapping for register page
    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Refers to register.jsp
    }

    // PostMapping for handling user login
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        User foundUser = userService.findByUsername(user.getUsername());

        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return "home"; // Redirect to home.jsp on successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Stay on login page with error
        }
    }

    // PostMapping for handling user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userService.usernameExists(user.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "register"; // Stay on register page with error
        }

        userService.saveUser(user); // Save new user
        model.addAttribute("message", "Registration successful! Please login.");
        return "login"; // Redirect to login page
    }
}
