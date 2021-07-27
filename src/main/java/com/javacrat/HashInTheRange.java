package com.javacrat;

import java.util.HashMap;

public class HashInTheRange {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(16, 1f);
        map.put("1","one");
        map.put("2","two");
        map.put("3","three");
        map.put("4","four");
        map.put("5","five");
        map.put("6","six");
        map.put("7","seven");
        map.put("8","eight");
        map.put("9","nine");
        map.put("10","ten");
        map.put("11","eleven");
        map.put("12","twelve");
        map.put("13","thirteen");
        map.put("4","fourteen");
        map.put("15","fifteen");
        map.put("16","sixteen");

        hash("1");
        hash("2");
        hash("3");
        hash("4");
        hash("5");
        hash("6");
        hash("7");
        hash("8");
        hash("9");
        hash("10");
        hash("11");
        hash("12");
        hash("13");
        hash("14");
        hash("15");
        hash("16");
    }

    static int hash(Object key) {
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        System.out.println("hashBefore:" + hash + "   hashAfter: " + (hash&15));
        return hash & 15;
    }
}
