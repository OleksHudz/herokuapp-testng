package com.herokuapp.tests.digestAuthentication.model;

public record DigestAuthenticationTestData(String digestAuthUrl,
                                           String header,
                                           String message) {
}
