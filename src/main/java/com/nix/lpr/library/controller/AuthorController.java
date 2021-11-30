package com.nix.lpr.library.controller;

import com.nix.lpr.library.entity.Author;
import com.nix.lpr.library.exception.entity.RestViolationException;
import com.nix.lpr.library.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "authors")
@Api(description = "Management system that performs actions with authors.", produces = "application/json")
public class AuthorController {

    private final AuthorService authorService;
    private final Validator validator;

    @Autowired
    public AuthorController(AuthorService authorService, @Qualifier("customValidator") Validator validator) {
        this.authorService = authorService;
        this.validator = validator;
    }

    @PostMapping(path = "addAuthor", consumes = "application/json")
    @ApiOperation(value = "Add an author.", notes = "Add a new author to the library database.")
    public void addAuthor(
            @ApiParam(name = "author", type = "com.nix.lpr.library.entity.Author",
                    value = "The author JSON represented object", required = true)
            @RequestBody Author author) {
        validateEntity(author);
        authorService.addAuthor(author);
    }

    @GetMapping
    @ApiOperation(value = "Get all authors.", notes = "Get paginated list of all authors from DB.")
    public List<Author> getAuthors(Pageable pageable) {
        return authorService.getAuthors(pageable).getContent();
    }

    private void validateEntity(Author author) {
        DataBinder dataBinder = new DataBinder(author);
        dataBinder.addValidators(validator);
        dataBinder.validate();

        List<String> errorMessages = dataBinder
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        throw new RestViolationException(errorMessages);
    }

}
