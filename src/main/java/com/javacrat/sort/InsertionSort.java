package com.javacrat.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[]{6,9,2,7,1,5,8,4,3};
        System.out.println("input :" + Arrays.toString(array));
        array = sort(array);
        System.out.println("output :" + Arrays.toString(array));
    }

    public static int[] sort(int[] array){
        int[] result = new int[0];
        for(int i=0; i<array.length; i++){
            result = insert(result, array[i]);
        }
        return result;
    }

    public static int[] insert(int[] array, int element){
        int[] inserted = new int[array.length + 1];
        if (array.length == 0 ) inserted[0] = element;
        int i=0, j=0;
        boolean isInserted = false;
        for (; i<array.length; i++,j++){
            if (array[i] < element || isInserted)
                inserted[j] = array[i];
            else if(!isInserted){
                inserted[j] = element;
                j++;
                inserted[j] = array[i];
                isInserted = true;
            }
        }
        if (!isInserted) inserted[inserted.length-1] = element;
        return inserted;
    }

}
