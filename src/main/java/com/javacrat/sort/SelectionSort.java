package com.javacrat.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{6,9,2,7,1,5,8,4,3};
        System.out.println("input :" + Arrays.toString(array));
        array = sort(array);
        System.out.println("output :" + Arrays.toString(array));
    }

    public static int[] sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int smallest = array[i];
            int indexOfSmallest = i;
            for (int j = i; j < array.length; j++) {
                if (smallest > array[j]) {
                    smallest = array[j];
                    indexOfSmallest = j;
                }
            }
            int temp = array[i];
            array[i] = smallest;
            array[indexOfSmallest] = temp;
        }
        return array;
    }

}
