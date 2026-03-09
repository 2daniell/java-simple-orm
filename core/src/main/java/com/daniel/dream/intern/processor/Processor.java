package com.daniel.dream.intern.processor;

import com.daniel.dream.intern.container.DreamContainer;

import java.lang.annotation.Annotation;

public interface Processor<A extends Annotation> {

    void process(Class<?> target, A annotation, DreamContainer container);

}
