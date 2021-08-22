package com.javacrat.maths;

public class Fibbonacci {

    public static void main(String[] args) {
        System.out.println(recursive(   9));
    }

    private static int recursive(int i) {
        if(i<=1) return i;
        return recursive(i-1) + recursive(i-2);
    }

}
