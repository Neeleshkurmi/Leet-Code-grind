package leetcodedaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
    //dec 17

    public static ListNode oddEvenList(ListNode head){
        if(head==null || head.next==null) return head;

        List<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while(temp!=null && temp.next!=null){
            list.add(temp.val);
            temp = temp.next.next;
        }
        if(temp!=null) list.add(temp.val);
        temp = head.next;

        while(temp!=null && temp.next!=null){
            list.add(temp.val);
            temp = temp.next.next;
        }
        if(temp!=null) list.add(temp.val);

        temp = head;
        int i=0;
        while(temp!=null){
            temp.val= list.get(i++);
            temp = temp.next;
        }
        return head;

    }
    //dec 16
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        if(n==1) return true;

        else if(n%3!=0 || n==0) return false;
        return isPowerOfThree(n/3);
    }

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

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
