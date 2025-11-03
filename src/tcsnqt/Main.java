// Online Java Compiler
// Use this editor to write, compile and run your Java code online
package tcsnqt;
import java.util.*;

class Main {
    public static void main(String[] args) {
        int [] arr = {3,2,4};
        int target =6;
        System.out.println(Arrays.toString(TwoSum(arr, target)));
    }
    
    public static int[] TwoSum(int [] nums, int target){
        int i=0, j=nums.length-1;
        while(i<j){
            int sum = nums[i] + nums[j];
            
            if(sum == target) return new int[] {i,j};
            
            else if(sum<target){
                if(nums[i]<nums[j]) i++;
                else j--;
            }
            else {
                if(nums[i]>nums[j]) i++;
                else j--;
            }
        }
        return new int[]{-1,-1};
    }
}