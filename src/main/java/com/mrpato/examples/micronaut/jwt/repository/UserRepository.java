package com.mrpato.examples.micronaut.jwt.repository;

import com.mrpato.examples.micronaut.jwt.domain.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import java.util.Optional;

@Singleton
public class UserRepository {

    private EntityManager entityManager;

    @Inject
    public UserRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<User> getByUsername(final String username) {
        User found = entityManager.createQuery("select u from User u where u.username =: username", User.class)
            .setParameter("username", username).getSingleResult();
        return Optional.ofNullable(found);
    }

}
