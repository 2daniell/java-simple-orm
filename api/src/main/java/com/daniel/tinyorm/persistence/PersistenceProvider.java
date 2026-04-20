package com.daniel.tinyorm.persistence;

public interface PersistenceProvider {

    PersistenceFactory create(PersistenceConfig config);
}
