package edu.ithaca.dragon.datastructures.set;

/**
 * A set is an unordered collection of *unique* items. 
 * No matter how many times the same item is added to a Set, 
 * it will only appear in the set once
 */
public interface StringSet {
    
    /**
     * @post Adds an item to the current set, if it is not already in the set.
     *       If the item was already in the set, the set remains unchanged
     */
    void add(String item);

    /**
     * @return true if the item is in the set, false otherwise
     */
    boolean contains(String item);

    /**
     * @return the current number of unique items in the set
     */
    int size();

    /**
     * @return a new array of all strings currently in the StringSet
     */
    String[] toArray();

    /**
     * @return a Set representing the union of this Set and otherSet,
     * meaning a Set containing all items that are in either this Set or otherSet, or both
     * see https://byjus.com/maths/set-operations/ for more description
     */
    StringSet union(StringSet otherSet);

    /**
     * @return a Set representing the intersection of this Set and otherSet,
     * meaning a Set containing only items that are in both this Set and otherSet
     * see https://byjus.com/maths/set-operations/ for more description
     */
    StringSet intersection(StringSet otherSet);
}
