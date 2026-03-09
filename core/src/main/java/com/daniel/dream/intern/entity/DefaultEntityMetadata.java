package com.daniel.dream.intern.entity;

public class DefaultEntityMetadata<T> implements EntityMetada<T> {

    private final Class<T> type;

    public DefaultEntityMetadata(Class<T> type) {
        this.type = type;
    }

    @Override
    public Class<T> getJavaType() {
        return type;
    }

    @Override
    public String getEntityName() {
        return type.getSimpleName().toLowerCase();
    }
}
