package com.lambdas;

import com.data.Student;
import com.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    static Consumer<Student> c1 = (student) -> System.out.println(student);
    static Consumer<Student> c2 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c3 = (student) -> System.out.println(student.getActivities());

    public static void getStudentName() {
        List<Student> students = StudentDatabase.getAllStudent();
        students.forEach(c1);
    }
    public static void printNameAndActivities() {
        List<Student> students = StudentDatabase.getAllStudent();
        students.forEach(c2.andThen(c3));
    }
    public static void printNameActivitiesWithCondition() {
        List<Student> students = StudentDatabase.getAllStudent();
        students.forEach((student -> {
            if(student.getGpa()>=3.9 && student.getGradeLevel()>=3) {
                c2.andThen(c3).accept(student);
            }
        }));
    }
    public static void main(String[] args) {
        Consumer<String> c1 = (str) -> System.out.println(str.toUpperCase());
        c1.accept("java8 new features.");
        // getStudentName();
        // printNameAndActivities();
        printNameActivitiesWithCondition();
    }
}
