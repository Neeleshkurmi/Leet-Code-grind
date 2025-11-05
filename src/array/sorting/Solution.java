package array.sorting;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
    int[] arr = {4,6,-2,-3};
    selectionSort(arr);
    System.out.println(Arrays.toString(arr));
}

    static void selectionSort(int[] arr){
        //4,6,2,3
        for(int i=0; i< arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                if(arr[j]<arr[i]){
                    swap(arr,i,j);
                }
            }
        }
    }

    static void insertionSort(int[] arr){

    }


    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
