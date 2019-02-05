package com.mrpato.examples.micronaut.jwt.security;

import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;

@Singleton
public class Authenticator implements AuthenticationProvider {

    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        return null;
    }

}
