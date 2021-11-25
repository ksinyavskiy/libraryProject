package com.nix.lpr.library.controller;

import com.nix.lpr.library.entity.Book;
import com.nix.lpr.library.exception.entity.BookNotFoundException;
import com.nix.lpr.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping(value = "{bookId}", produces = "application/json")
    public Book getBook(@PathVariable Integer bookId) {
        return bookService
                .getBookById(bookId)
                .orElseThrow(() -> new BookNotFoundException("There is no book with such id"));
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
}
