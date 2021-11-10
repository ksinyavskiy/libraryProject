package com.nix.lpr.library.controller;

import com.nix.lpr.library.entity.Author;
import com.nix.lpr.library.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "authors")
@Api(description = "Management system that performs actions with authors.", produces = "application/json")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "addAuthor", consumes = "application/json")
    @ApiOperation(value = "Add an author.", notes = "Add a new author to the library database.")
    public void addAuthor(
            @ApiParam(name = "author", type = "com.nix.lpr.library.entity.Author",
                    value = "The author JSON represented object", required = true)
            @RequestBody Author author) {
        authorService.addAuthor(author);
    }

}
