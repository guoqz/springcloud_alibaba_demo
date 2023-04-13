package com.skcx.test;

public class Demo6 {

    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");

        System.out.println(a == b); // true
        System.out.println(b == c); // false
    }

}
