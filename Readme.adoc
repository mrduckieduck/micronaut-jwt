= Micronaut + JWT authorization/authentication

This project works as an example of how should be configured a project using https://micronaut.io/[Micronaut]
and authorization and authentication using https://jwt.io/[JSON Web tokens (JWT)] and a simple data base (where are
stored all the users with a simple password and username (_UsernamePasswordAuthentication_).

== How to run the application?

As default Micronaut use https://gradle.org/[Gradle] as build tool, so as easy as just typing this in a console:

```
# gradle run
```
And this will start the application in a random port.

== How to test the application?

Just run the following command and all the specs will be run:
```
# gradle test
```