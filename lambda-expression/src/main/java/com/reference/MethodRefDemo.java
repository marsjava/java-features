package com.reference;

import java.util.function.Function;

public class MethodRefDemo {
    static Function<String, String> lambdaUpperCase = (s -> s.toUpperCase());
    static Function<String, String> methodRefUpperCase = (String::toUpperCase);
    public static void main(String[] args) {
        System.out.println(lambdaUpperCase.apply("java8"));
        System.out.println(methodRefUpperCase.apply("features"));
    }
}
