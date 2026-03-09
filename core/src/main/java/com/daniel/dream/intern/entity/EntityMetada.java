package com.daniel.dream.intern.entity;

import java.lang.reflect.Field;

public interface EntityMetada<T> {

    Class<T> getJavaType();

    String getEntityName();

}
