package array.slidingwindow;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println((prefixSum(new int[]{-1,1,1},1)));
    }

    static int prefixSum(int[] nums,int k){
        int maxL = Integer.MIN_VALUE;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            sum+=nums[i];

            if(sum==k){
                maxL= Math.max(sum,maxL);
            }
            int rem = nums[i] -k;
            if(map.containsKey(rem)){
                maxL =Math.max(i-map.get(rem),maxL);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxL;
    }

    static int[] firstNegativeInWindowSizeK(int[] nums, int k){
        int n = nums.length;
        int index =0;

        Queue<Integer> queue = new LinkedList<>();
        while (index<k){
            if(nums[index]<0){
                queue.offer(nums[index]);
            }
            index++;
        }

        int[] ans = new int[n-k+1];
        ans[0] = queue.isEmpty()?0:queue.peek();

        for(int i=1; i<n-k+1; i++){
            if(nums[i-1]<0){
                queue.poll();
            }
            if(nums[i+k-1]<0){
                queue.offer(nums[i+k-1]);
            }
            ans[i] = queue.isEmpty()?0: queue.peek();
        }
        return ans;
    }
}
