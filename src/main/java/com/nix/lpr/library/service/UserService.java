package com.nix.lpr.library.service;

import com.nix.lpr.library.dto.UserDto;
import com.nix.lpr.library.dto.UserView;
import com.nix.lpr.library.entity.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void addUser(User user);

    void deleteUser(Integer userId);

    User getUserById(Integer id);

    UserDto getUserViewByEmail(String email);

    UserView getUserViewByLogin(String login);

    List<User> getUsers();
}
