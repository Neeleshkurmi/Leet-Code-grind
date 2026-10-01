package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Solution {
    static void main() {
        System.out.println(new Solution().jobSequencing(
                new int[]{2, 1, 2, 1, 1},
                new int[]{100, 19, 27, 25, 15}
        ));
        // [ [1, 2, 100] , [2, 1, 19] , [3, 2, 27] , [4, 1, 25] , [5, 1, 15] ]
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int[][] jobs = new int[deadline.length][2];
        for(int i=0; i<jobs.length; i++){
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<jobs.length; i++){
            if(jobs[i][0] > pq.size()) {
                pq.offer(jobs[i][1]);
            }
            else if (pq.peek() < jobs[i][1]) {
                pq.poll();
                pq.offer(jobs[i][1]);
            }
        }
        int ans=0, cnt=pq.size();
        while(!pq.isEmpty()) {
            ans += pq.poll();
        }
       return new ArrayList<>(Arrays.asList(cnt, ans));
    }
}

class Pair {
    int deadline;
    int profit;

    public Pair(int d, int p){
        deadline = d;
        profit = p;
    }

    public void display() {
        System.out.println("deadline : " + deadline + ", profit : " + profit);
    }
}

