package com.clt;

public class Person {
    String name;
    String age;
    String tall;


    public Person() {
    }

    public Person(String name, String age, String tall) {
        this.name = name;
        this.age = age;
        this.tall = tall;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", tall='" + tall + '\'' +
                ']';
    }
}
