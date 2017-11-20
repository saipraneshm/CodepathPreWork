package interviewbit;


import java.util.List;
import java.util.PriorityQueue;

public class Checkpoint3 {

    public int kthsmallest(final List<Integer> a, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();

        pq.addAll(a);

        for(int i = 0; i < k - 1  ;i++){
            pq.poll();
        }

        return pq.peek();
    }


}
