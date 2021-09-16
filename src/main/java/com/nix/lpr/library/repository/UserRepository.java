package com.nix.lpr.library.repository;

import com.nix.lpr.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
