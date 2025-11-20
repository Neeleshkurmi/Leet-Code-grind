package leetcodedaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(upperBound(new int[]{0,2,2,2},2));
    }

    //nov 20
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