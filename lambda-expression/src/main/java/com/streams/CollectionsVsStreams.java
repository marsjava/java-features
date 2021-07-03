package com.streams;

import java.util.ArrayList;

/*
Collections
    *Can add or Modify elements at any point of time. For Example: List->list.add(<element>);
    *Elements in the collection can be accessed in any order. Use appropriate methods based on the collection.
       For example: List->list.get(4)
    *Collection is eagerly constructed.
    *Collection can be traversed 'n' number of times.
    *Performs External Iteration to iterate through the elements

Streams
    *Cannot add or modify elements in the stream. It is a fixed data set
    *Elements in the stream can be accessed only in sequence.
    *Streams are lazily constructed.
    *Streams can be traversed only once.
    *Performs Iternal Iteration to iterate through the elements.

 */

public class CollectionsVsStreams {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Antony");
        names.add("Ivan");
        names.remove(0);
        System.out.println(names);
        names.stream().forEach(System.out::println);
        names.stream().forEach(System.out::println);
    }
}
