package com.daniel.dream.repository;

import com.daniel.dream.intern.proxy.ProxyFactory;

import java.lang.reflect.Proxy;

public class RepositoryProxyFactory implements ProxyFactory {

    private final CrudRepositoryProxyHandler proxyHandler = new CrudRepositoryProxyHandler();

    @Override
    @SuppressWarnings("unchecked")
    public <T> T create(Class<T> target) {
        return (T) Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, proxyHandler);
    }

}
