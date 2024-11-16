package com.rd.service;

import com.rd.entity.User;
import com.rd.repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void addUser(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        userRepository.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
