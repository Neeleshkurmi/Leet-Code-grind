package leetcodedaily;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
    //dec 16
    class NumArray {
        int[] nums;
        Map<Integer, Integer> map = new HashMap<>();

        public NumArray(int[] nums) {
            this.nums = nums;
            map.put(-1,0);
            int sum =0;
            for(int i=0; i<nums.length; i++){
                sum+=nums[i];
                map.put(i,sum);
            }
        }

        public int sumRange(int left, int right) {
            return map.get(right)-map.get(left-1);
        }
    }

    public static String convertToTable(int n){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            n--;
            sb.append((char)('A'+(n%26)));
            n/=26;
        }
        sb.reverse();
        return sb.toString();
    }
}
