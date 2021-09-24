package com.nix.lpr.library.service;

import com.nix.lpr.library.entity.User;
import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(Integer userId);

    User getUserById(Integer id);

    List<User> getUsers();
}
