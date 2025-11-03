package coders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution {
    public static int maximumWealth(int[][] accounts) {
        int currentSum =0, maxSum=0;
        for(int i=0; i<accounts.length; i++){
            currentSum =0;
            for(int j=0; j<accounts[i].length; j++){
                currentSum+= accounts[i][j];
            }
            if(currentSum> maxSum){
                maxSum =currentSum;
            }
        }
        return maxSum;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();

        int i=0, j=0,k=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;j++;
            }
            else{
                if(nums1[i]>nums2[j]){
                    j++;
                }
                else{
                    i++;
                }
            }
        }
        int[] ans = new int[list.size()];
        for(int l=0; l<list.size(); l++){
            ans[k] = list.get(l);
            k++;
        }
        return ans;
    }

    public static boolean validPalindrome(String s) {
        boolean ans =false , in =false;
        int i=0,co=0;
        while(i<s.length()){
            if(i==0){
                ans = isPalindrome(s);
                i++;
                if(ans){
                    return ans;
                }
            }
            else{
                if(co==0){i--;co=1;}

                String copy = s;
                String c = String.valueOf(copy.charAt(i));
                copy = copy.replace(c,"");
                in = isPalindrome(copy);
                i++;
                if(in){
                    break;
                }
            }
        }
        return ans || in;
    }
    public static boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++; j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static int findNumbers(int[] nums) {
        int even =0;
        for(int i=0; i<nums.length; i++){
            if((count(nums[i]))%2==0){
                even++;
            }
        }
        return even;
    }

    public  static int count(int n){
        int count=0;
        if(n<10){
            return 1;
        }
        while(n>=1){
            n/=10;
            count++;
        }
        return count;
    }
    public static int[] shuffle(int[] nums, int n) {
        int [] ans = new int[nums.length];
        int i=0, j=n, k=0;
        while(k<nums.length){
            if(k%2==0 && n<nums.length){
                ans[k] = nums[i];
                i++;k++;
            }
            else {
                ans[k] = nums[j];
                j++;k++;
            }
        }
        return ans;
    }
    public static int maxArea(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondL= Integer.MIN_VALUE;
        int p=-1, n=-1;
        for (int i =0; i<nums.length; i++) {
            if (nums[i] > largest) {
                secondL = largest;
                largest = nums[i];
                p=i;
            } else if (nums[i] > secondL && nums[i] != largest) {
                secondL = nums[i];
                n = i;
            }
        }
        return Math.abs(p-n)*secondL;
    }
    public static boolean searchSortedMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1; // Start from the top-right corner

        while (row < rows && col >= 0) {
            int currentValue = matrix[row][col];

            if (currentValue == target) {
                return true;
            } else if (currentValue < target) {
                row++; // Move down
            } else {
                col--; // Move left
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1},new int[]{2,2})));
//        System.out.println(validPalindrome("cddcm"));
//        System.out.println(validPalindrome("eccer"));
//        System.out.println(validPalindrome("abca"));
//        System.out.println(maximumWealth(new int[][]{
//                {2,8,7},
//                {7,1,3},
//                {1,9,5}
//        }));
//        System.out.println(findNumbers(new int[]{12,345,2,6,7896}));
//        System.out.println(Arrays.toString(shuffle(new int[]{2,5,1,3,4,7},3)));
//        System.out.println(Arrays.toString(shuffle(new int[]{1,2,3,4,4,3,2,1},4)));
//        System.out.println(Arrays.toString(shuffle(new int[]{1,1,2,2},2)));
//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
//        System.out.println(maxArea(new int[]{1,1}));
        System.out.println(searchSortedMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        },3));
    }
}
