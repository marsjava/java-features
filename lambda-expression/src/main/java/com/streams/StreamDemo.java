package com.streams;

import com.data.Student;
import com.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {

        List<Student> studentList = StudentDatabase.getAllStudent().stream()
                .collect(Collectors.toList());
        System.out.println(studentList);

        Predicate<Student> chkGradeLevel = (student -> student.getGradeLevel()>3);
        Predicate<Student> chkGpaLevel = (student -> student.getGpa()>3.5);

        // Basically stream operation is a lazy
        // without Terminal operation, the intermediate is not performing
        // because the Terminal is start-up with stream operation
        // debugging the stream operations by using peek(Consumer c) method.

        System.out.println("\nStudent Map\n");
        Map<String, List<String>> studentMap = StudentDatabase.getAllStudent().stream()
                .peek((student -> {
                    System.out.println(student);
                }))
                .filter(chkGradeLevel)  //stream<Student> Intermediate stream operation
                .peek((student -> {
                    System.out.println("1st Filter\n"+student);
                }))
                .filter(chkGpaLevel)    //stream<Student> Intermediate stream operation
                .peek((student -> {
                    System.out.println("2nd Filter\n"+student);
                }))
                .collect(Collectors.toMap(Student::getName, Student::getActivities)); // Map Terminal stream operation
        System.out.println(studentMap);
    }
}
