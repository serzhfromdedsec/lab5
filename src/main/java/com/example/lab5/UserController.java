package com.example.lab5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        try {
            userService.register(username, password);
            return "redirect:/login";
        } catch (Exception e) {
            System.err.println("Error during registration: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}