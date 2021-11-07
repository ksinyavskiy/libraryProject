package com.nix.lpr.library.config.security;

import com.nix.lpr.library.entity.UserRole;
import com.nix.lpr.library.exception.handler.RestSecurityExceptionHandler;
import com.nix.lpr.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RestSecurityExceptionHandler restSecurityExceptionHandler;
    // these paths are important, the full access to Swagger will not work without them
    private final String[] WHITE_LIST_URL = new String[]{
            "/v2/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**"
    };

    @Autowired
    public SpringSecurityConfig(UserService userService, PasswordEncoder passwordEncoder,
                                RestSecurityExceptionHandler restSecurityExceptionHandler) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.restSecurityExceptionHandler = restSecurityExceptionHandler;
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(WHITE_LIST_URL).permitAll()
                .antMatchers("/users/{userId}").access("hasRole('ADMIN') or principal.username == #userId")
                .antMatchers("/users/**").hasRole(UserRole.ADMIN.toString())
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                    .authenticationEntryPoint(restSecurityExceptionHandler)
                    .accessDeniedHandler(restSecurityExceptionHandler)
                .and()
                .httpBasic();
    }
}
