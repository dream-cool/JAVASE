package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        int[] ints = new int[5];
//        int index = 0;
//        ints[5] = 1;
//        index = 100;
//        System.out.println(ints);
//
//        Person[] people = new Person[15];
//
//        LinkList<Person> list = new LinkList();
//        for (int i = 0 ; i < 10 ; i++){
//            Person person = new Person(i+"号","2"+i,"17"+i);
//            list.add(person);
//        }
//
//        list.toArrays(people);
//
//
//        System.out.println(Arrays.toString(people));



        Person[] people = new Person[2];

        List<Person> list = new LinkedList<>();
        for (int i = 0 ; i < 10 ; i++){
            Person person = new Person(i+"号","2"+i,"17"+i);
        }

        Person[] people1 = list.toArray(people);


        System.out.println(Arrays.toString(people1));

    }
}
