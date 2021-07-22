package com.javacrat.maths;

public class MathUtils {

    public static int gcd(int number1, int number2) {
        int gcd = 0;
        if (number1 == number2) return number1;
        int min = number1, max = number2;
        if (number1 >= number2) {
            max = number1;
            min = number2;
        }
        return gcd;
    }

    public static int lcm(int number1, int number2) {
        int lcm = 0;

        return lcm;
    }

    public static void main(String[] args) {
        int number1 = 3, number2=15;
        System.out.println("GCD of " + number1 + " and " + number2 + " is " + MathUtils.gcd(number1,number2));
    }

}
