package array.search;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{},3));
    }

    //complexity O(n)
    static int linearSearch(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] ==target) return i;
        }
        return -1;
    }

    //complexity O(log(n))
    static int binarySearch(int[] arr, int target){
        int start = 0; int end = arr.length-1;

        while(start<=end){
            int mid = start +(end -start) /2;
            if(arr[mid] ==target) return mid;
            else if (arr[mid]>target) end = mid-1;
            else start = mid +1;
        }
        return -1;
    }
}
