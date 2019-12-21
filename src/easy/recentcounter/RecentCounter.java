package easy.recentcounter;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class RecentCounter {
    SortedSet<Integer> pingTime;

    public RecentCounter() {
        pingTime = new TreeSet<>();
    }

    public int ping(int t) {
        pingTime.add(t);
        int start = t - 3000;
        return (pingTime.tailSet(start)).size();
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
}
