package com.nix.lpr.library.service;

import com.nix.lpr.library.entity.User;
import com.nix.lpr.library.exception.entity.UserNotFoundException;
import com.nix.lpr.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User %d doesn't exist", id)));
    }
}
