package array.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

//        System.out.println(binarySearch(new int[]{},3));
//        System.out.println(leader(new int[] {16, 17, 4, 3, 5, 2}));
//        System.out.println(search2(new int[]{1,0,1,1,1},0));
//        System.out.println(findMin(new int[]{2,1}));
        System.out.println(findMin(new int[]{1,2,3,4,5,6}));
        System.out.println(findMin(new int[]{8,1,2,3,4,5,6,7}));
        System.out.println(findMin(new int[]{1,2}));
        System.out.println(findMin(new int[]{2,0}));
        System.out.println(findMin(new int[]{6,7,8,1,2,3,4,5}));
    }

    //dec 6
    public static int findKRotation(int[] arr) {
//        int count =0;
//
//        for(int i=1; i<arr.length; i++){
//            if(arr[i]<arr[i-1]){
//                count = i;
//            }
//        }
//        return count;
        int start =0, end = arr.length-1;
        while(start<end){
            int mid = start+(end -start)/2;
            if(arr[start]>arr[mid]){
                end = mid;
            }
            else {
                start =mid+1;
            }
        }
        return start;
    }
    public static int findMin(int[] nums) {
        int ans= Integer.MAX_VALUE;
        int start = 0, end = nums.length-1;

        while(start<=end){
            int mid = start+ (end -start)/2;

            if(nums[start]<=nums[mid]){
                ans = Math.min(nums[start], ans);
                start = mid+1;
            }
            else{
                ans = Math.min(nums[mid], ans);
                end = mid-1;
            }
        }
        return ans;
    }

    //dec 5
    // variation 2 same question
    public static boolean search2(int[] nums, int target){
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = start+(end -start)/2;
            if(nums[mid]==target){
                return true;
            }
            //left half is rotated or not
            else if (nums[start]<=nums[mid]){
                if(target>=nums[start] && target<=nums[mid]){
                    end = mid -1;
                }
                else {
                    start = mid +1;
                }
            }
            else {
                if(target>=nums[mid] && target<=nums[end]){
                    start = mid+1;
                }
                else {
                    end = mid -1;
                }
            }
        }
        return false;
    }
    //search in sorted rotated array
    public static int search(int[] nums, int target){
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = start+(end -start)/2;
            if(nums[mid]==target){
                return mid;
            }
            //left half is rotated or not
            else if (nums[start]<=nums[mid]){
                if(target>=nums[start] && target<=nums[mid]){
                    end = mid -1;
                }
                else {
                    start = mid +1;
                }
            }
            else {
                if(target>=nums[mid] && target<=nums[end]){
                    start = mid+1;
                }
                else {
                    end = mid -1;
                }
            }
        }
        return -1;
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
