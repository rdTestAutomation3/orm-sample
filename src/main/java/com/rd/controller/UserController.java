package com.rd.controller;

import com.rd.service.UserService;

public class UserController {

    private final UserService userService = new UserService();

    public void createUser(String username, String email) {
        userService.addUser(username, email);
        System.out.println("User created successfully!");
    }

    public void listUsers() {
        userService.getAllUsers().forEach(user ->
                System.out.println(user.getId() + " - " + user.getUsername() + " - " + user.getEmail())
        );
    }
}

