package com.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ImperativeVsDeclarative2 {
    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(1,2,3,4,4,5,5,5,6,6,6,6,7,8,9,10);
        /**
         * Imperative style
         */
        List<Integer> uniqueList1 = new ArrayList<Integer>();
        for(Integer integer: arrayList) {
            if(!uniqueList1.contains(integer)) {
                uniqueList1.add(integer);
            }
        }
        System.out.println("UniqueList1: "+uniqueList1);
        /**
         * Declarative style
         */
        List<Integer> uniqueList2 = arrayList.stream().distinct().collect(Collectors.toList());
        System.out.println("UniqueList2: "+uniqueList2);
    }
}
