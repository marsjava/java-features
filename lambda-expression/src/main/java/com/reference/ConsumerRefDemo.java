package com.reference;

import com.data.Student;
import com.data.StudentDatabase;

import java.util.function.Consumer;

public class ConsumerRefDemo {

    static Consumer<Student> c1 = System.out::println;
    static Consumer<Student> c2 = Student::printActivities;
    public static void main(String[] args) {
        //StudentDatabase.getAllStudent().forEach(c1);
        StudentDatabase.getAllStudent().forEach(c2);
    }
}
