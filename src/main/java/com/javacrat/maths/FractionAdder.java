package com.javacrat.maths;

public class FractionAdder {

    public static void main(String[] args) {
        add(1, 4, 3, 8);
        add(2, 3, 5, 8);
    }

    private static void add(int n1, int d1, int n2, int d2) {
        int n = 0; int d=0;
        if (d1 == d2) {
            n = n1+n2;
            d = d1;
        } else {
            int lcm = lcm(d1, d2);
            d = lcm;
            n = n1*(lcm/d1) + n2*(lcm/d2);
        }
        System.out.println((n/gcd(n,d) + "/" + d/gcd(n,d)));
    }

    public static int gcd(int a, int b) {
        int gcd = 0;
        if (a==0) return b;
        if (b==0) return a;
        int min = (a > b) ? b : a;
        int max = (a <= b) ? b : a;
        for (int i = min; i > 0; i--) {
            if (a%i==0 && b%i==0){
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    public static int lcm(int a,int b) {
        int gcd = gcd(a,b);
        return (a*b)/gcd;
    }

}
