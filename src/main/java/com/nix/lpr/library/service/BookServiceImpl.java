package com.nix.lpr.library.service;

import com.nix.lpr.library.entity.Book;
import com.nix.lpr.library.repository.AuthorRepository;
import com.nix.lpr.library.repository.BookRepository;
import com.nix.lpr.library.repository.GenreRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        authorRepository.save(book.getAuthor());
        genreRepository.save(book.getGenre());
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }
}
