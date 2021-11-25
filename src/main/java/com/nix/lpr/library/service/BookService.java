package com.nix.lpr.library.service;

import com.nix.lpr.library.entity.Book;
import java.util.Optional;

public interface BookService {
    void addBook(Book book);

    Optional<Book> getBookById(Integer bookId);
}
