package com.nix.lpr.library.repository;

import com.nix.lpr.library.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
