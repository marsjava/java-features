package com.lambda;

import java.util.Comparator;

public class ComparatorLambda {
    public static void main(String[] args) {
        /**
         * Prior Java 8
         */
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("To compare Legacy way "+comparator.compare(3,2));

        /**
         * Lambda Expresion
         */
        Comparator<Integer> comparator1 = (Integer a, Integer b) -> {
            return a.compareTo(b);
        };
        System.out.println("To compare Lambda1 way "+comparator1.compare(3,2));

        Comparator<Integer> comparator2 = (a, b) -> {
            return a.compareTo(b);
        };
        System.out.println("To compare Lambda2 way "+comparator2.compare(3,2));

        Comparator<Integer> comparator3 = (a, b) -> a.compareTo(b);
        System.out.println("To compare Lambda3 way "+comparator3.compare(3,2));
    }
}
