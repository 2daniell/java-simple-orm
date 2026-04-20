package com.daniel.tinyorm.index;

import javax.annotation.processing.Filer;
import javax.tools.StandardLocation;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class IndexManager {

    private static final String INDEX_PATH = "META-INF/dream-orm/index.idx";

    private IndexManager() {}

    public static void write(Map<String, Set<String>> index, Filer filer) throws IOException {
        try (Writer writer = filer.createResource(StandardLocation.CLASS_OUTPUT, "", INDEX_PATH).openWriter()) {
            for (Map.Entry<String, Set<String>> entry : index.entrySet()) {

                String annotation = entry.getKey();
                Set<String> classes = entry.getValue();

                for (String className : classes) {
                    writer.write(annotation + ":" + className + "\n");
                }

            }
        }
    }

    public static Map<String, Set<String>> read(ClassLoader loader) {

        Map<String, Set<String>> index = new HashMap<>();

        try (InputStream stream = loader.getResourceAsStream(INDEX_PATH)) {

            if (stream == null) return null;

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(":");

                String annotation = parts[0];
                String clazz = parts[1];

                index.computeIfAbsent(annotation, k -> new HashSet<>()).add(clazz);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return index;

    }


}
