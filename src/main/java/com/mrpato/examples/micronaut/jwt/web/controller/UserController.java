package com.mrpato.examples.micronaut.jwt.web.controller;

import com.mrpato.examples.micronaut.jwt.exception.NotFoundException;
import com.mrpato.examples.micronaut.jwt.service.UserService;
import com.mrpato.examples.micronaut.jwt.service.model.User;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;

import javax.inject.Inject;

@Secured("isAuthenticated()")
@Controller("/user")
public class UserController {

    private UserService userService;

    @Inject
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public User findByUsername(@QueryValue("username") String username) {
        return userService.findByUsername(username)
            .orElseThrow(() -> new NotFoundException(String.format("User with %s not found", username)));
    }
}
