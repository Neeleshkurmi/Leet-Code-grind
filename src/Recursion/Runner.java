package Recursion;

import java.util.*;
public class Runner{
    static int cnt =0;
    static long MOD = 1_000_000_00_7;

    public static void main(String[] args) {
        // Stack<Integer> st = new Stack<>();

        // StackSolutions s = new StackSolutions();

        // st.push(1);
        // st.push(2);
        // st.push(3);
        // st.push(4);

        // System.out.println("Before Reverse: " + st);

        // s.reverse(st);

        // System.out.println("After Reverse: " + st);

        // s.sortStack(st);

        // System.out.println("After Sorting: " + st);

        System.out.println(numSubseq(new int[] {3,5,6,7}, 9));

    }

    public static int numSubseq(int[] nums, int target) {
        generate(nums, 0, target, new ArrayList<>());
        return (int) (cnt % MOD) ;
    }

    public static void generate(int[] nums, int index, int target, List<Integer> list){
        if(index == nums.length){
            if(list.isEmpty()) return;

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for(int num : list){
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            if((max+min) <= target) {
                cnt++;
            }
            return;
        }

        list.add(nums[index]);
        generate(nums, index+1, target, list);

        list.removeLast();
        generate(nums, index+1, target, list);
    }
}