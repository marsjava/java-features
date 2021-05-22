package com.basics;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {
    public static void main(String[] args) {
        /**
         * Imperative style programming
         */
        int sum = 0;
        for(int i=0;i<=100;i++){
            sum+=i;
        }
        System.out.println("Sum of Imperative style -> "+sum);

        /**
         * Declarative style programming - What style of programming
         */
        int sum1 = IntStream.rangeClosed(0, 100).sum();
        System.out.println("Sum of Declarative style -> "+sum1);
    }
}
