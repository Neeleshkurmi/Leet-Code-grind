package revision;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(check(new int[]{3,4,5,1,2}));
        int[] arr = {1,2,3,4,5};
        rotate(arr,2);
        System.out.println(Arrays.toString(arr));

    }

    //dec 13 2025
    public static boolean check(int[] nums) {
        int count =0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>nums[(i+1)%nums.length]) count++;
        }
        return count<=1;
    }

    private static int shift(int[] nums){
        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[i]!=nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return i+1;
    }

    private static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums, k, nums.length-1);
    }
    private static void reverse(int[] nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}
