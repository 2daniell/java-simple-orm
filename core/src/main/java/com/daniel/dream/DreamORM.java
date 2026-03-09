package com.daniel.dream;

import com.daniel.dream.annotation.Repository;
import com.daniel.dream.intern.container.DreamContainer;
import com.daniel.dream.intern.processor.Processor;
import com.daniel.dream.intern.processor.RepositoryProcessor;
import com.daniel.dream.intern.proxy.ProxyFactory;
import com.daniel.dream.repository.CrudRepository;
import com.daniel.dream.repository.RepositoryProxyFactory;
import com.daniel.dream.scanner.Scanner;
import com.daniel.dream.scanner.ScannerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;

public final class DreamORM {

    private static boolean isRunning = false;

    private static final DreamContainer container = new DreamContainer();


    private DreamORM() {}

    public static void run() {
        DreamORM orm = getInstance();
        DreamORM.isRunning = true;
        orm.initialize();
    }

    public static <T, ID> CrudRepository<T, ID> getRepository(Class<? extends CrudRepository<T, ID>> type) {
        return container.getRepository(type);
    }

    public DreamContainer getContainer() {
        return container;
    }

    private void initialize() {
        ProxyFactory factory = new RepositoryProxyFactory();
        RepositoryProcessor processor = new RepositoryProcessor(factory);

        Scanner scanner = ScannerFactory.getScanner();

        for (Class<?> clazz : scanner.getAnnotated(Repository.class)) {

            Repository a = clazz.getAnnotation(Repository.class);

            processor.process(clazz, a, container);
        }

    }

    private static DreamORM getInstance() {
        if (DreamORM.isRunning) throw new RuntimeException("Runtime Error");
        return new DreamORM();
    }
}
