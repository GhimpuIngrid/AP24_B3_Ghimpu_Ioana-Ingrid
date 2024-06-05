package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Prototype {
    public Prototype(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());
        printModifiers(clazz.getModifiers());
        System.out.println("Superclass: " + clazz.getSuperclass().getName());

        System.out.println("Constructors:");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            printConstructor(constructor);
        }

        System.out.println("Fields:");
        for (Field field : clazz.getDeclaredFields()) {
            printField(field);
        }

        System.out.println("Methods:");
        for (Method method : clazz.getDeclaredMethods()) {
            printMethod(method);
        }
    }

    private void printMethod(Method method) {
        System.out.println(Modifier.toString(method.getModifiers()) + " " +
                method.getReturnType().getName() + " " +
                method.getName() + "(" + getParameterTypes(method.getParameterTypes()) + ")");
    }

    private void printField(Field field) {
        System.out.println(Modifier.toString(field.getModifiers()) + " " +
                field.getType().getName() + " " + field.getName());
    }

    private void printConstructor(Constructor<?> constructor) {
        System.out.println(Modifier.toString(constructor.getModifiers()) + " " +
                constructor.getName() + "(" + getParameterTypes(constructor.getParameterTypes()) + ")");
    }

    private void printModifiers(int modifiers) {
        System.out.println(Modifier.toString(modifiers));
    }

    private static String getParameterTypes(Class<?>[] parameterTypes) {
        StringBuilder params = new StringBuilder();
        for (int i = 0; i < parameterTypes.length; i++) {
            params.append(parameterTypes[i].getName());
            if (i < parameterTypes.length - 1) {
                params.append(", ");
            }
        }
        return params.toString();
    }
}
