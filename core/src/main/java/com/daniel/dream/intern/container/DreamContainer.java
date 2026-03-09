package com.daniel.dream.intern.container;

import com.daniel.dream.intern.entity.EntityMetada;
import com.daniel.dream.repository.CrudRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
public final class DreamContainer {

    private final Map<Class<?>, EntityMetada<?>> entities = new HashMap<>();
    private final Map<Class<?>, Object> repositories = new HashMap<>();

    public void registerEntity(EntityMetada<?> entityMetada) {
        Class<?> type = entityMetada.getJavaType();
        entities.put(type, entityMetada);
    }

    public Optional<EntityMetada<?>> getEntity(Class<?> type) {
        return Optional.ofNullable(entities.get(type));
    }

    public void registerRepositry(Class<?> type, Object repository) {
        repositories.put(type, repository);
    }

    @SuppressWarnings("unchecked")
    public <T> T getRepository(Class<T> type) {
        return (T) repositories.get(type);
    }

}
