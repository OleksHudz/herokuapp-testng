package com.herokuapp.tests.redirectLink.model;

public record RedirectLinkTestData(String redirectionHeader,
                                   String statusCodesHeader,
                                   int link200,
                                   int link301,
                                   int link404,
                                   int link500
) {
}
