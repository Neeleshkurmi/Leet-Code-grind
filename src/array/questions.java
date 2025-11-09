package array;

import java.util.*;

public class questions {
    public static void main(String[] args) {
        System.out.println(minimumDistance(new int[] {4,4,4,4,4}));
        System.out.println(minMaxDifference(90));
        System.out.println(Arrays.toString(divideString("ctoyjrwtngqwt",8,'n')));
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
