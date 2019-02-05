package com.mrpato.examples.micronaut.jwt.service;


import com.mrpato.examples.micronaut.jwt.repository.UserRepository;
import com.mrpato.examples.micronaut.jwt.service.model.User;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class UserService {

    private UserRepository userRepository;

    @Inject
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(final String username) {
        return userRepository.getByUsername(username)
            .map(user -> new User(user.getId(), user.getUsername(), user.getName()));
    }

}
