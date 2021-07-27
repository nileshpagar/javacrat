package com.javacrat.maths;

public class MathUtils {

    public static int gcd(int number1, int number2) {
        int gcd = 0;
        if (number1 == number2) return number1;
        int min = number1;
        if (number1 > number2) {
            min = number2;
        }
        for (int i = min; i > 0; i--) {
            if (number1%i == 0 && number2%i ==0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    public static int lcm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    public static void main(String[] args) {
        int number1 = 6, number2=15;
        System.out.println("GCD of " + number1 + " and " + number2 + " is " + MathUtils.gcd(number1,number2));
        System.out.println("LCM of " + number1 + " and " + number2 + " is " + MathUtils.lcm(number1,number2));
    }

}
