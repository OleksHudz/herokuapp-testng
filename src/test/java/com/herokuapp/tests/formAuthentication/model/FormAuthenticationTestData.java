package com.herokuapp.tests.formAuthentication.model;

public record FormAuthenticationTestData(String header,
                                         String validUsername,
                                         String invalidUsername,
                                         String password,
                                         String successLoginMessage,
                                         String logoutMessage,
                                         String failLoginMessage) {
}
