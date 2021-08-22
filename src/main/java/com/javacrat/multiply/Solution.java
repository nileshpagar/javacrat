package com.javacrat.multiply;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.String.valueOf;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
class Solution {

    public String multiply(String num1, String num2) {
        String answer = "0";
        char[] chars = num2.toCharArray();
        if(num1.equals("0") || num2.equals("0")) return answer;
        for(int i=chars.length-1 ; i>=0; i--) {
            answer = add(answer, _multiply(num1, chars[i]) + getNumberOfZeroes(chars.length-1-i));
        }
        return answer;
    }

    public String add(String num1, String num2) {
        if(num1.equals("0")) return num2;
        if(num2.equals("0")) return num1;
        else {
            String answer = "";
            int carryForward = 0;
            for(int i = 0; i<(max(num1.length(), num2.length())); i++) {
                int addition = (num1.length()-1-i>=0? parseInt(valueOf(num1.toCharArray()[num1.length() - 1 - i])) :0) + (num2.length()-1-i>=0? parseInt(valueOf(num2.toCharArray()[num2.length() - 1 - i])) :0) + carryForward;
                answer = addition%10 + answer;
                carryForward = addition/10;
            }
            if(carryForward >0) answer = carryForward + answer;
            return answer;
        }
    }

    private String getNumberOfZeroes(int count){
        StringBuilder zeroes = new StringBuilder();
        for(int i=0; i<count; i++)
            zeroes.append(0);
        return zeroes.toString();
    }

    private static String _multiply(String chars, char ch) {
        if(ch == '0') return "0";
        int multiplier = parseInt(valueOf(ch));
        String answer = "";
        int carryForward = 0;
        for(int i=chars.toCharArray().length-1 ; i>=0; i--) {
            int value = parseInt(valueOf(chars.toCharArray()[i]));
            int product = multiplier * value + carryForward;
            int remainder = product%10;
            answer = remainder + answer;
            carryForward = product/10;
        }
        if (carryForward != 0)
            answer = carryForward + answer;
        return answer;
    }

}
