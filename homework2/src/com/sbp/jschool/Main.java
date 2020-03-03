package com.sbp.jschool;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person(true, "Joe");
        Person p2 = new Person(true, "Bob");
        Person p3 = new Person(false, "Jill");
        Person p4 = new Person(false, "Margo");
        p1.marry(p3);
        p2.marry(p4);
        p1.marry(p4);
    }
}
