package com.nix.lpr.library.controller;

import com.nix.lpr.library.dto.UserDto;
import com.nix.lpr.library.dto.UserView;
import com.nix.lpr.library.entity.User;
import com.nix.lpr.library.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "users")
@Api(description = "Management system that performs actions with library users.", produces = "application/json")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
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

    @GetMapping(path = "getViewByLogin/{login}", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "Get user view.", notes = "Get user specific view using his login", response = UserView.class)
    public UserView getViewByLogin(
            @ApiParam(name = "login", type = "String", value = "User login from DB", example = "lol42", required = true)
            @PathVariable("login") String login) {
        return userService.getUserViewByLogin(login);
    }

    @GetMapping
    @ApiOperation(value = "Get users operation.",
            notes = "Get all users available in the database.", response = List.class)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "email")
    @ApiOperation(value = "Get users operation.",
            notes = "Get all users which prefix email is the same as specified in the input data.",
            response = List.class)
    public List<User> getUsersByPrefixEmail(@RequestParam("prefixEmail") String prefixEmail) {
        return userService.getUsersByEmailStartsWith(prefixEmail);
    }

}
