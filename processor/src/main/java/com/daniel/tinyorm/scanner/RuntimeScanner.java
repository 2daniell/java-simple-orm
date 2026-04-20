package com.daniel.tinyorm.scanner;

import com.daniel.tinyorm.index.IndexManager;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class RuntimeScanner implements Scanner {

    private final Map<String, Set<String>> index;

    RuntimeScanner(ClassLoader classLoader) {
        this.index = IndexManager.read(classLoader);
    }

    @Override
    public Iterable<Class<?>> getAnnotated(Class<? extends Annotation> annotation) {

        Set<String> classNames = index.get(annotation.getName());

        if (classNames == null) return Set.of();

        Set<Class<?>> classes = new HashSet<>();

        for (String className : classNames) {
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return classes;
    }
}
