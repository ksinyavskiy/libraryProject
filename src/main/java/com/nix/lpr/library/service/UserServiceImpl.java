package com.nix.lpr.library.service;

import com.nix.lpr.library.dto.UserDto;
import com.nix.lpr.library.dto.UserView;
import com.nix.lpr.library.entity.Permission;
import com.nix.lpr.library.entity.User;
import com.nix.lpr.library.exception.entity.UserNotFoundException;
import com.nix.lpr.library.repository.UserRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User %d doesn't exist", id)));
    }

    @Override
    public UserDto getUserViewByEmail(String email) {
        return userRepository
                .getByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with %s email doesn't exist", email)));
    }

    @Override
    public UserView getUserViewByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByEmailStartsWith(String emailPrefix) {
        User user = new User();
        user.setEmail(emailPrefix);

        ExampleMatcher prefixEmailMatcher = ExampleMatcher
                                        .matchingAll()
                                        .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.startsWith());
        return userRepository.findAll(Example.of(user, prefixEmailMatcher));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByLogin(username);
        return new org.springframework.security.core.userdetails.User(
                String.valueOf(user.getUserId()),
                passwordEncoder.encode(user.getPassword()),
                getUserAuthorities(user)
        );
    }

    private Set<GrantedAuthority> getUserAuthorities(User user) {
        Set<GrantedAuthority> grantedAuthorities =  user.getRole().getPermissions().stream()
                   .map(Permission::getName)
                   .map(SimpleGrantedAuthority::new)
                   .collect(Collectors.toSet());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));

        return grantedAuthorities;
    }
}
