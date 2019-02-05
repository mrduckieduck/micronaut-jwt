package com.mrpato.examples.micronaut.jwt.service.security;

import com.mrpato.examples.micronaut.jwt.repository.UserRepository;
import io.micronaut.security.authentication.*;
import io.micronaut.spring.tx.annotation.Transactional;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;

@Singleton
public class Authenticator implements AuthenticationProvider {

    private UserRepository userRepository;

    @Inject
    public Authenticator(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        return userRepository.getByUsername(String.valueOf(authenticationRequest.getIdentity()))
            .filter(user -> user.getPassword().equals(String.valueOf(authenticationRequest.getSecret())))
            .map(user -> (AuthenticationResponse)new UserDetails(user.getUsername(), Collections.emptyList()))
            .map(Flowable::just)
            .orElseGet(() -> Flowable.just(new AuthenticationFailed()));
    }

}
