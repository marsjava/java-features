package com.lambdas;

import com.data.Student;
import com.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerDemo {
    static BiConsumer<String, List<String>> biConsumer = (name, activities) -> {
        System.out.println(name+" : "+activities);
    };
    public static void printNameAndActivities() {
        List<Student> students = StudentDatabase.getAllStudent();
        students.forEach((student -> {
            biConsumer.accept(student.getName(), student.getActivities());
        }));
    }
    public static void main(String[] args) {
        BiConsumer<String, String> consumer = (a, b) -> {
            System.out.println("a: "+a.toUpperCase()+"b: "+b.toUpperCase());
        };
        consumer.accept("java7", "java8");
        BiConsumer<Integer, Integer> multiply = (a, b) -> {
            System.out.println("Multiplication: "+(a*b));
        };
        BiConsumer<Integer, Integer> division = (a, b) -> {
            System.out.println("Division: "+(a/b));
        };
        multiply.andThen(division).accept(12, 3);
        printNameAndActivities();
    }
}
