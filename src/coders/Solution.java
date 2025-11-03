package coders;

import java.util.*;

public class Solution {

//    public  static List<Integer> findSubstring(String s, String[] words) {
//       return 0;
//    }
public  static int removeElement(int[] nums, int val) {
    int i=0, j=0;
    while(nums[i]!=val){
        i++; j++;
    }
    while(j< nums.length){
        if(nums[j]==val){
            j++;
        }
        else{
            swap(nums,i,j);
            j++; i++;
        }
    }
    return i;
}


    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('A');set.add('e');
        set.add('E');set.add('i');set.add('I');
        set.add('o');set.add('O');set.add('u');set.add('U');

        int i=0, j=s.length()-1;
        char[] ans = s.toCharArray();

        while(i<=j){
            while(!set.contains(ans[i]) && i<j){
                i++;
            }
            while(!set.contains(ans[j]) && i<j){
                j--;
            }
            swap(ans,i,j);
            i++; j--;
        }
        return String.valueOf(ans);
    }
    public static void swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {


        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length && j-i <=k; j++){

                if(nums[i]==nums[j] && Math.abs(i-j)<=k){
                    return true;
                }
            }
        }
        return false;
    }

    public static double findMaxAverage(int[] nums, int k) {
        double myK = Integer.valueOf(k);
        double currentAvg =0, maxAvg =0;
        double sum =0;
        int i =0;
        int j=0;

        if(nums.length ==1) return (double) nums[0] /k;

        while(j<nums.length){

            if(sum==0){
                for(j=0; j<k; j++) sum+=nums[j];
            }
            else if(sum!=0){
                sum+=nums[j]- nums[i];
                j++;
                i++;
            }
            currentAvg = sum / myK;
            if(currentAvg>maxAvg){
                maxAvg = currentAvg;
            }
        }
        return maxAvg;
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxSize =0;
        Set<Character> set = new HashSet<>();

        for(char a : s.toCharArray()){
            if(set.contains(a)){
                if(set.size()>maxSize) {
                    maxSize = set.size();
                }
                set.clear();
                set.add(a);
            }
            else {
                set.add(a);
            }
        }
        return maxSize;
    }

    public static int findKthPositive(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        quickSort(nums, 0, nums.length - 1);

        int j=0;

            for(int i=1; i<=nums.length+k; i++){
                if(list.size()<k){
                    if(i!=nums[j]){
                        list.add(i);
                    }
                    else if(i==nums[j] && j< nums.length -1){
                        j++;
                    }
                }

            }


        int sum =0;
        for(int i=0; i<list.size(); i++){
            sum += list.get(i);
        }
        return sum;
    }

    public  static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at correct place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // This method takes last element as pivot, places the pivot element at its correct position in sorted array,
    // and places all smaller (than pivot) to left of pivot and all greater elements to right of pivot
    private  static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing the last element as pivot
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;

    }
    public static void main(String[] args) {
//        System.out.println(reverseVowels("leetcode"));
//        System.out.println(reverseVowels("IceCreAm"));
//        String s = "and";
//        s.indexOf("a");
        System.out.println(removeElement(new int[]{3,2,2,3},3));


//        System.out.println(containsNearbyDuplicate(new int[] {1,0,1,1},1));System.out.println(nums.length);
//        System.out.println(a);
//        sortColors(nums);
//        System.out.println(Arrays.toString(nums));


//        int n=4
//                ;
//        for(int i=0; i<n-1; i++){
//            int space = (n/2)-i;
//
//            for(int j=1; j<=space+1; j++ ){
//                System.out.print(" ");
//            }
//            int stars = i+1;
//            for(int j=1; j<=stars; j++){
//                System.out.print("* ");
//            }
//            for(int j=1; j<=space+1; j++ ){
//                System.out.print(" ");
//            }
//            System.out.println();1,0,1,1
//        }
//        for(int i=n-2; i>=0; i--){
//            int space = (n/2)-i;
//
//            for(int j=1; j<=space+1; j++ ){
//                System.out.print(" ");
//            }
//            int stars = i+1;
//            for(int j=1; j<=stars; j++){
//                System.out.print("* ");
//            }
//            for(int j=1; j<=space+1; j++ ){
//                System.out.print(" ");
//            }
//            System.out.println();
//        }



    }
    public static void sortColors(int[] nums) {
        int low = 0, high = nums.length-1, mid= high/2;

        while(mid<high && low < mid){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
            }
            else if(nums[mid]==2){
                swap(nums,high,mid);
                high--;
            }
            else {
                mid++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}