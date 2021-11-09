package com.nix.lpr.library.repository;

import com.nix.lpr.library.dto.UserDto;
import com.nix.lpr.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByLogin(String login);

    Optional<UserDto> getByEmail(String email);
}
