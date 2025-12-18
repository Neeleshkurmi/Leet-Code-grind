package leetcodedaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat "));
    }

    //dec 18
    public static ListNode swapPairs(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode first = head, second = head.next;

        while(second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;

            first= first.next.next;
            second= (second.next==null)? null: second.next.next;
        }
        return head;
    }
    //dec 17

    public static boolean wordPattern(String pattern, String s) {
        StringBuilder[] sb = new StringBuilder[pattern.length()];

        for(int i=0; i<pattern.length(); i++){
            sb[i] = new StringBuilder();
        }
        int j=0;
        String curr="";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' ') {
                sb[j].append(curr);
                j++;
                curr="";
            }
            else{
                curr+=s.charAt(i);
            }
        }
        if(!curr.equals(""))sb[j].append(curr);

        if(sb[sb.length - 1].toString().isEmpty()) return false;

        Map<Character, String> map = new HashMap<>();
        j=0;
        for(int i=0; i<pattern.length(); i++){
            if(map.containsKey(s.charAt(i)) && !map.get(s.charAt(i)).contentEquals(sb[j])){
                return false;
            }
            map.put(s.charAt(i), sb[j++].toString());
        }
        return true;
    }

    public static ListNode oddEvenList(ListNode head){
        if(head==null || head.next==null) return head;

//        List<Integer> list = new ArrayList<>();
//
//        ListNode temp = head;
//
//        while(temp!=null && temp.next!=null){
//            list.add(temp.val);
//            temp = temp.next.next;
//        }
//        if(temp!=null) list.add(temp.val);
//        temp = head.next;
//
//        while(temp!=null && temp.next!=null){
//            list.add(temp.val);
//            temp = temp.next.next;
//        }
//        if(temp!=null) list.add(temp.val);
//
//        temp = head;
//        int i=0;
//        while(temp!=null){
//            temp.val= list.get(i++);
//            temp = temp.next;
//        }
//        return head;

        ListNode odd = head, even = head.next, evenHead=head.next;

        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
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
