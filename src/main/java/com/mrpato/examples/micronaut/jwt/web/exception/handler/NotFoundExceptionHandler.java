package com.mrpato.examples.micronaut.jwt.web.exception.handler;

import com.mrpato.examples.micronaut.jwt.exception.NotFoundException;
import com.mrpato.examples.micronaut.jwt.web.exception.handler.model.Error;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Singleton
public class NotFoundExceptionHandler implements ExceptionHandler<NotFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, NotFoundException exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        error.setCode(String.valueOf(HttpStatus.NOT_FOUND.getCode()));
        return HttpResponse.notFound(error);
    }

}
