package Recursion;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int cnt = per(new int[]{4, 9, 2, 5, 1}, 10, 0);
        System.out.println(cnt);
	}
	
	public static void per(int[] nums, int target, int index, List<Integer> res){
	    if(index == nums.length){
	        if(target==0){
	            System.out.println(res);
	            return;
	        }
	        return;
	    }
	    
	    if(nums[index] <= target){
	        
	        res.add(nums[index]);
	        per(nums, target-nums[index], index+1, res);
	        res.removeLast();
	    }
	    
	    
	    per(nums, target, index+1, res);
	}
	
	public static int per(int[] nums, int target, int index){
	    if(index == nums.length){
	        if(target==0){
	            return 1;
	        }
	        return 0;
	    }
	    int pick = 0;
	    if(nums[index] <= target){
	        pick = per(nums, target-nums[index], index+1);
	    }
	    
	    
	    int notPick=per(nums, target, index+1);

        return pick + notPick;
	}
	
	public static boolean permute(int[] nums, int target, int index){
	    if(index == nums.length){
	        if(target==0){
	            return true;
	        }
	        return false;
	    }
	    
	    boolean ans = false;
	    
	    if(nums[index] <= target){
	        ans = permute(nums, target-nums[index], index+1);
	    }
	    
	    return permute(nums, target, index+1) || ans;
	}
	
	public static void dfs(int open, int close, int n, String pair){
	    if(open + close == 2*n){
	        System.out.println(pair);
	        return;
	    }
	    
	    if(open < n){
	        dfs(open + 1, close, n, pair+"(");
	    }
	    if(close < open){
	        dfs(open, close + 1, n, pair+")");
	    }
	}
	
	public static boolean checkSubsequenceSum(int[] nums, int k) {
        return permute(nums, k, 0);
    }

    static void generateSubsequences(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if(index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(arr[index]);
        generateSubsequences(arr,index+1, current, result);

        current.removeLast();
        generateSubsequences(arr, index+1, current,result);
    }
}