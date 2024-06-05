package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Tests {

    public static int[] runTests(Class<?> clazz) throws Exception {
        int passed = 0, failed = 0;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    if (Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                        method.invoke(null);
                    } else {
                        Object instance = clazz.getDeclaredConstructor().newInstance();
                        Object[] mockParameters = createMockParameters(method.getParameterTypes());
                        method.invoke(instance, mockParameters);
                    }
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", method, ex.getCause());
                    failed++;
                }
            }
        }
        return new int[]{passed, failed};
    }

    private static Object[] createMockParameters(Class<?>[] parameterTypes) {
        Object[] mockParameters = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i] == int.class) {
                mockParameters[i] = 1;
            } else if (parameterTypes[i] == String.class) {
                mockParameters[i] = "mock";
            } else {
                mockParameters[i] = null;
            }
        }
        return mockParameters;
    }
}
