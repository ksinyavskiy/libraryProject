package com.nix.lpr.library.service;

import com.nix.lpr.library.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    void addAuthor(Author author);

    void deleteAuthor(Integer id);

    Author getAuthorById(Integer id);

    Page<Author> getAuthors(Pageable pageable);
}
