package com.daniel.tinyorm.persistence;

import com.daniel.tinyorm.query.Query;

public interface PersistenceManager {

    <T> Query<T> createNativeQuery(String query, Class<T> clazz);

}
