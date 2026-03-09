package com.daniel.dream.intern.proxy;

public interface ProxyFactory {

    <T> T create(Class<T> target);
}
