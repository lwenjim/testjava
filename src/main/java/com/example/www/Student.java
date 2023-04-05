package com.example.www;


public class Student {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i <100000; i++) {
            System.out.println(i);
        }
        System.out.printf("%d\n", System.currentTimeMillis() - start);
    }
}