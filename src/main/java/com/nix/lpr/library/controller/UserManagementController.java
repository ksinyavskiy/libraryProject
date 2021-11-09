package com.nix.lpr.library.controller;

import com.nix.lpr.library.dto.UserDto;
import com.nix.lpr.library.entity.User;
import com.nix.lpr.library.service.UserService;

import java.util.List;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
@Api(description = "Library management system that performs actions with library users.", produces = "application/json")
public class UserManagementController {

    private final UserService userService;

    @Autowired
    public UserManagementController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ApiOperation(value = "Add user operation.", notes = "Add a new user to the library database.")
    public void addUser(
            @ApiParam(name = "user", type = "User", value = "Input user data in JSON format.") @RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping(path = "delete/{userId}", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "Delete user operation.",
            notes = "Delete a particular user from the library database using his ID.")
    public void deleteUser(
            @ApiParam(name = "userId", type = "Integer",
                    value = "User unique ID value from the database.", example = "5", required = true)
            @PathVariable Integer userId) {
        userService.deleteUser(userId);
    }

    @GetMapping(path = "{userId}", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "Get user operation.", notes = "Get a particular user via his ID.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User was successfully retrieved from the database."),
            @ApiResponse(code = 500, message = "User with specified ID doesn't exist in the database.")
    })
    public User getUser(
            @ApiParam(name = "userId", type = "Integer",
                    value = "User unique ID value from the database.", example = "2", required = true)
            @PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(path = "getViewByEmail", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "Get user view.",
            notes = "Get user specific view via user email value", response = UserDto.class)
    public UserDto getViewByEmail(
            @ApiParam(name = "email", type = "String", value = "User email value from DB", required = true)
            @RequestParam("email") String email) {
        return userService.getUserViewByEmail(email);
    }

    @GetMapping
    @ApiOperation(value = "Get users operation.",
            notes = "Get all users available in the database.", response = List.class)
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
