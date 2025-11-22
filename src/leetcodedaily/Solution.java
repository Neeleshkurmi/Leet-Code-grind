package leetcodedaily;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,3,4,5,1}));

    }

    //no 22
    public int minimumOperations(int[] nums) {
        int count =0;

        for(int num : nums){
            if(num%3!=0) count++;
        }
        return count;
    }

    //nov 21
    static int findMin(int[] nums) {
        int start =0, end =nums.length-1;

        while(start<end){
            int mid = (start+end)/2;

            if(nums[mid]>nums[mid+1]){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return nums[start];
    }
    static int singleNonDuplicate(int[] nums) {
        int xor =0;

        for(int i=0; i<nums.length; i++){
            xor^=nums[i];
            xor^=(i+1)^(i+1);
        }
        return xor;
    }
    static int countPalindromicSubsequence(String s) {
        Set<Character> set = new HashSet<>();
        int ans =0;
        for(int i=0; i<s.length(); i++){

            if(!set.contains(s.charAt(i))){
                int last = last(s, i);
                if(last!=-1){
                    int unique = unique(s, i+1, last-1);
                    ans +=unique;
                }
                set.add(s.charAt(i));
            }
        }
        return ans;
    }
    static int unique(String s, int start, int end){
        Set<Character> set = new HashSet<>();

        while(start<=end){
            set.add(s.charAt(start));
            start++;
        }
        return set.size();
    }
    static int last(String s, int start){
        int last =-1;
        for(int i=start+1; i<s.length(); i++){
            if(s.charAt(start) == s.charAt(i)){
                last = i;
            }
        }
        return last;
    }
    public static int search(ArrayList<Integer> arr, int n, int k) {
        int start =0, end = n-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(arr.get(mid)==k){
                return mid;
            }
            else if(arr.get(start)<=k && arr.get(mid)>k){
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return -1;
    }
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