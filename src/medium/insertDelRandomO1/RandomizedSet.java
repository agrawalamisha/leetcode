package medium.insertDelRandomO1;

import java.util.HashMap;
import java.util.HashSet;

public class RandomizedSet {
    HashSet<Integer> randomSet;
    HashMap<Integer, Integer> randomMap;
    int setSize;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        randomSet = new HashSet<>();
        randomMap = new HashMap<>();
        setSize = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (randomSet.contains(val)) {
            return false;
        } else {
            randomSet.add(val);
            randomMap.put(setSize, val);
            setSize++;
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!randomSet.contains(val)) {
            return false;
        } else {
            randomSet.remove(val);
            randomMap.remove(val);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int)(Math.random() * setSize);
        return randomMap.get(index);
    }

    public static void main(String[] args) {
        // Your RandomizedSet object will be instantiated and called as such:
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(10);
        boolean param_2 = obj.remove(10);
        int param_3 = obj.getRandom();
    }
    public static void main2(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

        // Returns false as 2 does not exist in the set.
        randomSet.remove(2);

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

        // getRandom should return either 1 or 2 randomly.
        randomSet.getRandom();

        // Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

        // 2 was already in the set, so return false.
        randomSet.insert(2);

        // Since 2 is the only number in the set, getRandom always return 2.
        randomSet.getRandom();
    }
}

