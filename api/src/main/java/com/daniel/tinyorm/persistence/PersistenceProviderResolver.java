package com.daniel.tinyorm.persistence;

import java.util.ServiceLoader;

class PersistenceProviderResolver {

    private static final PersistenceProvider PROVIDER = load();

    private static PersistenceProvider load() {
        return ServiceLoader.load(PersistenceProvider.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No provider found"));
    }

    public static PersistenceProvider getProvider() {
        return PROVIDER;
    }
}
