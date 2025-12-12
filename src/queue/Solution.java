package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(studentsLeft(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }

    //dec 12
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
