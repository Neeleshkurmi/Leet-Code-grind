package array.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{},3));

        System.out.println(leader(new int[] {16, 17, 4, 3, 5, 2}));
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

    static List<Integer> leader(int[] nums){
        ArrayList<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]>max){
                result.add(nums[i]);
                max = nums[i];
            }
        }
        Collections.reverse(result);
        return result;
    }
}
