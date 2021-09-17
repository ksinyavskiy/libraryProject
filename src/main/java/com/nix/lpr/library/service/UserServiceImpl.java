package com.nix.lpr.library.service;

import com.nix.lpr.library.entity.User;
import com.nix.lpr.library.exception.entity.UserNotFoundException;
import com.nix.lpr.library.repository.UserRepository;
import java.util.List;
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
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User %d doesn't exist", id)));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
