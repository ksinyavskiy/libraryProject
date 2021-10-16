package com.nix.lpr.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nix.lpr.library.controller"))
                // here we shouldn't use a pattern like "/users/**" in the Spring Security config
                // instead we have to use the following pattern - /users.* to display all web services in swagger-ui
                .paths(PathSelectors.regex("/users.*"))
                .build()
                .apiInfo(apiInfo());
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfo("LPR RESTful Library API",
                "REST API documentation for user interaction with the library management system.",
                "1.0",
                "https://termsUrl.com",
                new Contact("Sinyavskiy Kirill", "https://lprLibraryProject.com", "javadevsinyavskiy@gmail.com"),
                "LPR Project License",
                "https://lprProjectFreeLisence.com",
                Collections.emptyList());
    }
}
