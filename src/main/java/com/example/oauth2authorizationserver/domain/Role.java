package com.example.oauth2authorizationserver.domain;

import java.util.stream.Stream;

public enum Role {
    ROLE_USER,
    ROLE_ADMIN;

    public static String[] getValues() {
        return Stream.of(values())
                .map(Enum::name)
                .toArray(String[]::new);
    }
}
