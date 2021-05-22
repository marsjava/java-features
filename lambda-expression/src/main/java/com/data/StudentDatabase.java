package com.data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class StudentDatabase {
    public static Supplier<Student> getStudent = () -> {
        return new Student("Adam", 2, 3.6, "Male", Arrays.asList("swimming", "basketball", "volleyball"));
    };
    public static List<Student> getAllStudent() {
        Student student1 = new Student("Adam", 2, 3.6, "Male", Arrays.asList("swimming", "basketball", "volleyball"));
        Student student2 = new Student("Jenny", 2, 3.8, "Female", Arrays.asList("swimming", "gymnastics", "soccer"));

        Student student3 = new Student("Emily", 3, 4.0, "Female", Arrays.asList("swimming", "gymnastics", "aerobics"));
        Student student4 = new Student("Dave", 3, 3.9, "Male", Arrays.asList("swimming", "gymnastics", "soccer"));

        Student student5 = new Student("Shopia", 4, 3.5, "Female", Arrays.asList("swimming", "dancing", "football"));
        Student student6 = new Student("James", 4, 3.9, "Male", Arrays.asList("swimming", "basketball","baseball", "football"));

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6);
        return  students;
    }
}
