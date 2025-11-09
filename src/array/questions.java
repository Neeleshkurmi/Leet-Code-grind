package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class questions {
    public static void main(String[] args) {
        System.out.println(minimumDistance(new int[] {4,4,4,4,4}));
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
