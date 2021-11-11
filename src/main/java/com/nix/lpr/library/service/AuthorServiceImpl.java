package com.nix.lpr.library.service;

import com.nix.lpr.library.entity.Author;
import com.nix.lpr.library.exception.entity.AuthorNotFoundException;
import com.nix.lpr.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    @PreAuthorize(value = "hasRole('ADMIN')")
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    @PreAuthorize(value = "hasRole('ADMIN')")
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    @PreAuthorize(value = "#username == principal.username")
    public Author getAuthorById(Integer id) {
        return authorRepository
                .getByAuthorId(id)
                .orElseThrow(() -> new AuthorNotFoundException(String.format("Author with %d id doesn't exist", id)));
    }

    @Override
    @PostAuthorize(value = "hasAnyRole('ADMIN', 'STUDENT')")
    public Page<Author> getAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }
}
