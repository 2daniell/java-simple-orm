package com.daniel.tinyorm.persistence;

public record PersistenceConfig(
        String user,
        String url,
        String password
) { }
