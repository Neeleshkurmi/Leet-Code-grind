package array;

import java.util.*;

public class questions {
    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{2, 10, 4}));
        System.out.println(maxLength(new int[] {1, 0, -4, 3, 1, 0}));
        System.out.println(maxLength(new int[] {15, -2, 2, -8, 1, 7, 10, 23}));
        System.out.println(maxLength(new int[] {41,-45 ,-44 ,-24 ,20, 10 ,44}));
        System.out.println(maxLength(new int[] {-31 ,-48, -90 ,54 ,20 ,95, 6 ,-86, 22
        }));
    }

    static int maxLength(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxL = 0;
        int sum =0;

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum==0){
                maxL = Math.max(maxL,i+1);
            }
            if(map.containsKey(sum)){
                maxL = Math.max(maxL, i-map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return maxL;
    }
    public static List<List<Integer>> pascals(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if(numRows==1){
            return result;
        }
        result.add(Arrays.asList(1,1));
        if(numRows==2){
            return result;
        }
        numRows=numRows-2;
        int j=1;
        while(numRows>0){
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for(int i=1; i<result.size(); i++){
                current.add(result.get(j).get(i-1) + result.get(j).get(i));
            }
            current.add(1);
            j++;
            result.add(current);
            numRows--;
        }
        return result;
    }
    public static List<Integer> spiralOrder(int[][] matrix, int m, int n) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols-1, top = 0, bottom = rows-1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum =0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];

            if(sum>max){
                max = sum;
            }

            if(sum<0){
                sum =0;
            }
        }
        return max;
    }
    public static void nextPermutation(int[] nums) {
        int index =-1;

        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        if(index ==-1){
            reverse(nums, 0, nums.length-1);
            return;
        }
        int min =-1;
        for(int i=nums.length-1; i>index; i--){
            if(nums[i]>nums[index]){
                min = i;
                break;
            }
        }
        swap(nums, index, min);
        Arrays.sort(nums, index+1, nums.length);
    }
    static int romanToInteger(String s){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1); map.put('v',5); map.put('X',10);
        map.put('L',50); map.put('M',1000); map.put('C',100); map.put('D',500);

        int ans = map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2; i>=0; i--){
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                ans-=map.get(s.charAt(i));
            }
            else{
                ans+=map.get(s.charAt(i));
            }
        }
        return ans;
    }
    static void rotate(int[] nums, int k){
        k= k%nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums, k, nums.length-1);

    }
    static void reverse(int [] nums, int start, int end){
        while(start<=end){
            swap(nums, start, end);
            start++; end--;
        }
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static String[] divideString(String s, int k, char fill) {
        int temp =k;
        int size = (s.length()/k) + (s.length()%k);
        List<String> result = new ArrayList<>();

        int j=0;
        for(int i=0; i<size; i++){
            if(s.length()>=temp){
                result.add(s.substring(j,k));
                s = s.substring(k,s.length());
            }
            else {
                result.add(s);
                break;
            }
        }
        if(result.getLast().length()<temp){
            int rem = temp-result.getLast().length();
            for(int i=1; i<=rem; i++){
                result.set(result.getLast().length(),result.getLast()+fill);
            }
        }
        String[] ans = new String[result.size()];
        for(int i=0;i<result.size(); i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
    public static int minMaxDifference(int num) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String s = String.valueOf(num);
        for(int i=0; i<s.length(); i++){
            String temp1 = s;
            String temp2 = s;

            temp1 = temp1.replaceAll(String.valueOf(s.charAt(i)),"9");
//            System.out.println("temp1 = "+ temp1);
            max = Math.max(max,Integer.valueOf(temp1));

            temp2 = temp2.replaceAll(String.valueOf(s.charAt(i)), "0");
//            System.out.println("temp1 = "+ temp2);
            min = Math.min(min, Integer.valueOf(temp2));
        }
        return max - min;
    }
    //leet code contest question
    public static int minimumDistance(int[] nums){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            // adds the list of indices  ---> if key is not present ? create new list : append new index in the list
            map.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
        }

        int minD =Integer.MAX_VALUE;
        boolean found =false;

        for(List<Integer> temp : map.values()){
            if(temp.size()<3) continue; // id triplets are more then 3
            found =true;

            //to compute more then 3 triplets to achieve min length
            for (int i = 0; i+2 <temp.size(); i++) {
                int a = temp.get(i);
                int c = temp.get(i+2);
                int distance = 2*(c-a);
                minD = Math.min(minD, distance);
            }
        }
        return found?minD : -1;
    }
}
