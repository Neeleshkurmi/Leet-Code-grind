package leetcodedaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},6)));
    }

    //nov 21
    static int count(int arr[], int target) {
        int last = last(arr, target);
        int first = first(arr, target);
        return first>=0 && last>=0 ? last-first+1 : 0;
    }
    static int[] occour(int[] nums, int target){
        return new int[]{first(nums,target),last(nums,target)};
    }
    static int first(int[] nums, int target){
        int ans =-1 , start = 0, end = nums.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]==target){
                ans = mid;
                end = mid-1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else {
                start = mid +1;
            }
        }
        return ans;
    }
    static int last(int[] nums, int target){
        int ans =-1, start = 0, end = nums.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]==target){
                ans = mid;
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else {
                start = mid +1;
            }
        }
        return ans;
    }

    //nov 20
    static int[] searchRange(int[] nums, int target) {
        int first = first(nums,target);
        int last = last(nums,target);
        return new int[]{first,last};
    }

    static int findFloor(int[] arr, int x) {
        int ans =-1, start =0, end = arr.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid]<=x){
                ans  = mid ;
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return ans;
    }
    static int searchInsert(int[] nums, int target) {
        int ans = nums.length, start =0, end = ans-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]>=target){
                ans = mid;
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return ans;
    }
    static int upperBound(int[] nums, int target){
        int n = nums.length, start =0, end = n-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]>target){
                n =mid;
                end = mid-1;
            }
            else {
                start = mid +1;
            }
        }
        return n;
    }
    static int lowerBound(int[] nums, int target){
        int n = nums.length, start = 0, end = n-1;

        while(start<=end){
            int mid = (start+end) /2;

            if(nums[mid]>=target){
                n = mid;
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return n;
    }
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        List<Integer> nums = new ArrayList<>();

        int cnt = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int count = 0;

            for (int i = nums.size() - 1; i >= 0; i--) {
                if (nums.get(i) >= start && nums.get(i) <= end) {
                    count++;
                    if (count == 2) break;
                }
            }

            if (count == 0) {
                nums.add(end - 1);
                nums.add(end);
                cnt += 2;
            } else if (count == 1) {
                nums.add(end);
                cnt += 1;
            }
        }

        return cnt;
    }
}