package com.daniel.tinyorm.persistence;

import java.util.function.Consumer;

public class TinyORM {

    private static final PersistenceProvider provider = PersistenceProviderResolver.getProvider();

    private TinyORM() {}

    public static PersistenceFactory create(PersistenceConfig config) {
        return provider.create(config);
    }
}
