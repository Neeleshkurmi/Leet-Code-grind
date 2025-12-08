package array.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

//        System.out.println(binarySearch(new int[]{},3));
//        System.out.println(leader(new int[] {16, 17, 4, 3, 5, 2}));
//        System.out.println(search2(new int[]{1,0,1,1,1},0));
//        System.out.println(findMin(new int[]{2,1}));
//        System.out.println(findKRotation(new int[]{1,2,3,4,5,6}));
//        System.out.println(findKRotation(new int[]{8,1,2,3,4,5,6,7}));
//        System.out.println(findKRotation(new int[]{1,2}));
//        System.out.println(findKRotation(new int[]{2,0}));
//        System.out.println(findKRotation(new int[]{6,7,8,1,2,3,4,5}));\\\
//        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
//        System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));
//        System.out.println(mySqrt(8));
//        System.out.println(mySqrt(5));
//        System.out.println(mySqrt(13));
//        System.out.println(mySqrt(16));
//        System.out.println(mySqrt(1));
//        System.out.println(Math.sqrt(9));

        System.out.println(minEatingSpeed(new int[]{23,11,23,4,20},5));
        System.out.println(ceil(2,7));
        System.out.println(smallestDivisor(new int[]{44,22,33,11,1},5));
    }
    //dec 8
    public static int smallestDivisor(int[] nums, int threshold) {
        int ans =Integer.MAX_VALUE;
        int start =1, end = maxR(nums);

        while(start<=end){
            int mid = start+(end - start)/2;
            int sum = sum(nums,mid);
            if(sum<=threshold){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

    private static int sum(int[] nums, int div){
        int sum=0;
        for(int num: nums){
            sum+= ceil(num,div);
        }
        return sum;
    }

    //dec 7
    //https://leetcode.com/problems/koko-eating-bananas/
    public static int minEatingSpeed(int[] piles, int h) {

        int start = 1, end = maxR(piles);
        int ans=1;

        while(start<=end){
            int mid = start+(end - start)/2;

            if(speed(piles, mid)<=h){
                ans = mid;
                end = mid-1;
            }
            else{
                start= mid+1;
            }
        }
        return ans;
    }

    private static int maxR(int[] nums){
        int max = nums[0];
        for(int num:nums){
            if(num>max) max= num;
        }
        return max;
    }

    private static long speed(int[] nums, int speed) {
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += ceil(nums[i], speed);
        }
        return total;
    }

    private static int ceil(int num, int speed) {
        return (num + speed - 1) / speed;
    }


    //https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
    public static int nThRoot(int n, int m){
        if(m==0) return 0;

        int start =1, end =m;

        while (start<=end){
            int mid = (end+start)/2;
            int ans = (int)(Math.pow(mid,n));

            if(ans==m) return mid;

            else if(ans>m) end = mid-1;

            else start = mid+1;
        }
        return -1;
    }


    //dec 6
    //https://leetcode.com/problems/sqrtx/submissions/1848606840
    public static int mySqrt(int x) {
        if(x==0 || x==1) return x;

        int start =1, end =x;
        int ans =1;

        while(start<=end){
            int mid =  start+ (end - start)/2;

            if(mid==x/mid) return mid;

            else if(mid<x/mid){
                ans = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }

    public static int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1, peek=Integer.MIN_VALUE;
        int index=0;

        while(start<end){
            int mid = start+(end - start)/2;

            if(nums[mid]<nums[mid+1]){
                peek = (nums[mid+1]>peek)? nums[index = mid+1] : peek;
                start = mid+1;
            }
            else{
                peek = (nums[mid]>peek)? nums[index = mid] : peek;
                end = mid;
            }
        }
        return index;
    }

    public static int singleNonDuplicate(int[] nums) {
        int xor =0;

        for(int i=0; i<nums.length; i++){
            xor^=nums[i];
        }
        return xor;
    }

    public static int findKRotation(int[] nums) {
        int index =0, ans =Integer.MAX_VALUE;
        int start = 0, end = nums.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(nums[start]<=nums[mid]){
                ans = (nums[start]<ans)? nums[index=start] : ans;
                start = mid+1;
            }
            else{
                ans = (nums[mid]<ans)? nums[index=mid] : ans;
                end = mid-1;
            }
        }
        return index;
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
