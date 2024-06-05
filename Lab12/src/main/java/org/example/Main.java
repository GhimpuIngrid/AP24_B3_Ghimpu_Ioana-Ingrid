package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            return;
        }

        String inputPath = args[0];
        List<Class<?>> classes = new ArrayList<>();

        File inputFile = new File(inputPath);
        if (inputFile.isDirectory()) {
            processDirectory(inputFile, classes);
        } else {
            classes.add(Class.forName(inputPath));
        }

        for (Class<?> clazz : classes) {
            new Prototype(clazz);
            int[] results = Tests.runTests(clazz);
            System.out.printf("Class: %s - Passed: %d, Failed: %d%n", clazz.getName(), results[0], results[1]);
        }
    }


    private static void processDirectory(File dir, List<Class<?>> classes) throws IOException {
        Path startPath = Paths.get(dir.toURI());
        Files.walkFileTree(startPath, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".class")) {
                    String className = startPath.relativize(file).toString()
                            .replace(File.separator, ".").replace(".class", "");
                    try {
                        classes.add(Class.forName(className));
                    } catch (ClassNotFoundException e) {
                        System.out.println("Class not found: " + className);
                    }
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("visit file failed: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
    }
}


