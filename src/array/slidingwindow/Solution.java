package array.slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(firstNegativeInWindowSizeK(new int[]{12,-1,-7,8,-15,30,16,28},3)));
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
