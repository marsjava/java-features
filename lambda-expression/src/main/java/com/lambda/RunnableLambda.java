package com.lambda;

public class RunnableLambda {
    public static void main(String[] args) {

        /**
         * Prior Java8
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable-1");
            }
        };
        new Thread(runnable).start();

        /**
         * Java 8 - Lambda syntax
         * () -> {}
         */

        Runnable runnable1 = () -> {
            System.out.println("Inside Runnable-2");
        };
        Runnable runnable2 = () -> {
            System.out.println("Inside Runnable-3.0");
            System.out.println("Inside Runnable-3.1");
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable-4.0");
            }
        }).start();
        new Thread(() -> System.out.println("Inside Runnable-4.1")).start();


    }
}

