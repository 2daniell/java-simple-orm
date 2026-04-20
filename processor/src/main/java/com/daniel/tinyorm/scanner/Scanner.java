package com.daniel.tinyorm.scanner;

import java.lang.annotation.Annotation;

public interface Scanner {

    Iterable<Class<?>> getAnnotated(Class<? extends Annotation> annotation);

}
