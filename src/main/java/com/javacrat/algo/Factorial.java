package com.javacrat.algo;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorialRecursive(7));
    }

    /**
     * factorial with Recursive Method
     * @param i
     * @return
     */
    public static int factorialRecursive(int i) {
        if (i==0 || i ==1) return 1;
        return i * factorialRecursive(i-1);
    }

    /**
     * factorial with Dynamic Programming Algo Technique, Tabulation(Bottom Up) method.
     * @param i
     * @return
     */
    public static int factorialDynamicProgrammingTabulationMethod(int i) {
        return 0;
    }

    /**
     * factorial with Dynamic Programming Algo Technique, Memoization(Top Down) method.
     * @param i
     * @return
     */
    public static int factorialDynamicProgrammingMemoizationMethod(int i) {
        return 0;
    }

}
