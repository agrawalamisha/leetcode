package easy.recentcounter2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> pingTime;

    public RecentCounter() {
        pingTime = new LinkedList<>();
        dq = new LinkedList<>();
    }

    public Deque<Integer> dq;

    public int ping2(int t) {
        pingTime.offer(t);
        int start = t - 3000;
        while (!pingTime.isEmpty() && t - pingTime.peek() > 3000) {
            pingTime.poll();
        }
        return pingTime.size();
    }

    public int ping(int t) {
        while (!dq.isEmpty() && t - dq.getFirst() > 3000) {
            dq.removeFirst();
        }
        dq.addLast(t);
        return dq.size();
    }
}
/*
    public static void main(String[] args)
    {
        // Create a TreeSet and inserting elements
        SortedSet<String> s = new TreeSet<>();

        // Adding Element to SortedSet
        s.add("Geeks");
        s.add("For");
        s.add("Geeks");
        s.add("Code");
        s.add("It");

        // Returning the set with elements
        // strictly less than the passed value
        System.out.print("Element greater than or equal to G in set is : "
                + s.tailSet("G"));
    }*/

