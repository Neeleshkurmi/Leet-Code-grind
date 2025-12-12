package queue;

import java.util.*;

public class Solution {

      class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static void main(String[] args) {
        System.out.println(studentsLeft(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }

    //dec 12
    public void reverse(List<Integer> list, int i, int j){
        while(i<j){
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            j--; i++;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;

        List<Integer> ans = new ArrayList<>();
        while(head!=null){
            ans.add(head.val);
            head = head.next;
        }
        int n = ans.size();
        if (n == 0) return null;
        k = k % n;
        if (k == 0) {
            ListNode dummy = new ListNode(-1), tail = dummy;
            for (int v : ans) { tail.next = new ListNode(v); tail = tail.next; }
            return dummy.next;
        }
        reverse(ans, 0, ans.size()-1);
        reverse(ans, 0, k-1);
        reverse(ans, k, ans.size()-1);

        ListNode dummy = new ListNode(-1), tail = dummy;
        for (int v : ans) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    public void add(int val, ListNode head){
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }
    public static int studentsLeft(int[] students, int[] sandwitches){
        int n = students.length;
        Deque<Integer> s = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            q.offer(students[i]);
            s.push(sandwitches[n-i-1]);
        }

        int count =0;
        while(count<s.size()){
            if(Objects.equals(q.peek(), s.peek())){
                count =0;
                q.poll(); s.pop();
            }
            else{
                q.offer(q.poll());
                count++;
            }
        }
        return s.size();
    }
}
