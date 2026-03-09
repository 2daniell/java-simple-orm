package com.daniel.dream.intern.processor;

import com.daniel.dream.annotation.Repository;
import com.daniel.dream.intern.container.DreamContainer;
import com.daniel.dream.intern.proxy.ProxyFactory;

public final class RepositoryProcessor implements Processor<Repository> {

    private final ProxyFactory proxyFactory;

    public RepositoryProcessor(ProxyFactory proxyFactory) {
        this.proxyFactory = proxyFactory;
    }

    @Override
    public void process(Class<?> target, Repository annotation, DreamContainer container) {
        Object proxy = proxyFactory.create(target);
        container.registerRepositry(target, proxy);
    }
}
