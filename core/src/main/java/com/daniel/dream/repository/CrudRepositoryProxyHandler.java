package com.daniel.dream.repository;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CrudRepositoryProxyHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("deleteById")) {
            System.out.println("Capturado DeleteById para ID: " + args[0]);
        } else {
            throw new UnsupportedOperationException("Error");
        }
        return proxy;
    }
}
