package com.daniel.tinyorm.processor.collector;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class ClassIndexCollector {

    private final Map<String, Set<String>> collected = new HashMap<>();

    public void collect(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv, String packagePrefix) {
        for (TypeElement annotation : annotations) {

            String annotationName = annotation.getQualifiedName().toString();

            if (!annotationName.startsWith(packagePrefix)) continue;

            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);

            Set<String> classElements = annotatedElements.stream().filter(e -> e instanceof  TypeElement)
                    .map(e -> ((TypeElement) e).getQualifiedName().toString())
                    .collect(Collectors.toSet());

            collected.computeIfAbsent(annotationName, k -> new HashSet<>()).addAll(classElements);
        }
    }

    public Map<String, Set<String>> getCollected() {
        return collected;
    }
}
