package com.nix.lpr.library.service;

import com.nix.lpr.library.entity.Author;
import com.nix.lpr.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }
}
