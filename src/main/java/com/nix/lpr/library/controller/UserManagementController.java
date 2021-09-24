package com.nix.lpr.library.controller;

import com.nix.lpr.library.entity.User;
import com.nix.lpr.library.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "users")
public class UserManagementController {

    private final UserService userService;

    @Autowired
    public UserManagementController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping(path = "delete/{userId}", produces = "application/json;charset=UTF-8")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }

    @GetMapping(path = "{userId}", produces = "application/json;charset=UTF-8")
    public User getUser(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
