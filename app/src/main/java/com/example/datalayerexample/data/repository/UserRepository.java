package com.example.datalayerexample.data.repository;

import java.util.UUID;

public final class UserRepository {
    private static final UUID CURRENT = UUID.fromString("e58ed763-928c-4155-bee9-fdbaaadc15f3");

    private UserRepository() {
    }

    public static UUID currentUserId() {
        return CURRENT;
    }
}
