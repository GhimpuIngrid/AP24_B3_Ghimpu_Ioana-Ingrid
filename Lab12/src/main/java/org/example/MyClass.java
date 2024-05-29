package org.example;

public class MyClass {
    @Test
    public static void testMethod1() {
        System.out.println("Test method 1 executed");
    }

    @Test
    public static void testMethod2() {
        System.out.println("Test method 2 executed");
    }

    public static void methodWithoutTest() {
        System.out.println("This method should not be executed");
    }

    @Test
    public static void testMethod3() {
        throw new RuntimeException("Test method 3 failed");
    }
}
