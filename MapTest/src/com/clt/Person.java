package com.clt;

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {
    String name;
    String age;
    String tall;

    public Person(String name, String age, String tall) {
        this.name = name;
        this.age = age;
        this.tall = tall;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ",age='" + age + '\'' +
                ",tall='" + tall + '\'' +
                ']';
    }

    @Override
    public int compareTo(Person p) {
        if (this.age.compareTo(p.age) > 0){
            return 1;
        } else if (this.age.compareTo(p.age) < 0){
            return -1;
        } else {
            return 0;
        }
    }
}
