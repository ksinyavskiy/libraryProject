package com.nix.lpr.library.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "authors")
@Api(description = "Management system that performs actions with authors.", produces = "application/json")
public class AuthorManagementController {
}
