package com.reference;

import com.data.Student;
import com.data.StudentDatabase;

import java.util.function.Predicate;

public class RefractorRefDemo {
    static Predicate<Student> predicate = RefractorRefDemo::checkGradeLevel;
    public static boolean checkGradeLevel(Student s) {
        return s.getGradeLevel()>=3;
    }
    public static void main(String[] args) {
        System.out.println(predicate.test(StudentDatabase.getStudent.get()));
    }
}
