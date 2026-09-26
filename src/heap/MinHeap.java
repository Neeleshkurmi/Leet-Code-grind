import java.util.*;

public class MinHeap {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<10; i++) {
            pq.offer(i);
        }

        while(!pq.isEmpty()) {
            System.out.print(pq.poll() + ", ");
        }
    }
}