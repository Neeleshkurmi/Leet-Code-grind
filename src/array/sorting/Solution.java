package array.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {4,6,-2,-3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        int low = 0, high = arr.length-1;
        mergeS(arr,low,high);
    }

    public static void mergeS(int[] arr, int low, int high){
        if(low>=high) return;
        int mid = (low + high) /2;

        mergeS(arr,low,mid);
        mergeS(arr,mid+1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int [] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }

        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low; i<=high; i++){
            arr[i] = temp.get(i-low);
        }
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
