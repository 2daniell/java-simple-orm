package com.daniel.dream.repository;

import java.util.Optional;

public interface CrudRepository<T, ID> {

    T save(T entity);

    Optional<T> findById(ID id);

    Iterable<T> findAll();

    void deleteById(ID id);

    void delete(T entity);
}
