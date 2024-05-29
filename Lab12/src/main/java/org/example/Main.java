package org.example;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java org.example.Main <class-name>");
            return;
        }

        int passed = 0, failed = 0;
        Class<?> clazz = Class.forName(args[0]);

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", method, ex.getCause());
                    failed++;
                }
            }
        }

        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}
