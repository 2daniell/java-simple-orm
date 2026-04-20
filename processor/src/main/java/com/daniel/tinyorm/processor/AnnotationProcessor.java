package com.daniel.tinyorm.processor;

import com.daniel.tinyorm.processor.collector.ClassIndexCollector;
import com.daniel.tinyorm.index.IndexManager;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@SupportedAnnotationTypes("com.daniel.tinyorm.annotation.*")
public class AnnotationProcessor extends AbstractProcessor {

    private static final String ANNOTATIONS_PACKAGE = "com.daniel.dream.annotation";

    private final ClassIndexCollector collector = new ClassIndexCollector();

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        if (roundEnv.processingOver()) {

            Map<String, Set<String>> collected = collector.getCollected();

            try {
                IndexManager.write(collected, processingEnv.getFiler());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return true;
        }

        collector.collect(annotations, roundEnv, ANNOTATIONS_PACKAGE);

        return true;
    }
}
