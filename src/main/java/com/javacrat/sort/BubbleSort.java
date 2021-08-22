package com.javacrat.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{6,9,2,7,1,5,8,4,3};
        System.out.println("input :" + Arrays.toString(array));
        array = _sort(array);
        System.out.println("output :" + Arrays.toString(array));
    }

    public static int[] sort(int[] array){
        boolean changed;
        do{
            changed = false;
            for(int i=array.length-1; i>=0; i--){
                if (i-1>=0 && array[i] < array[i-1]){
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    changed = true;
                }
            }
        } while(changed);
        return array;
    }

    public static int[] _sort(int[] array){
        int n = array.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(array[j-1] > array[j]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array;
    }

}
