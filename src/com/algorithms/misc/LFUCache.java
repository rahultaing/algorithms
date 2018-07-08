package com.algorithms.misc;

/*
https://leetcode.com/problems/lfu-cache/discuss/94521/JAVA-O(1)-very-easy-solution-using-3-HashMaps-and-LinkedHashSet

Design and implement a data structure for Least Frequently Used (LFU) cache.
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present.
When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.
For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),
the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

*/

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    /*key - is the key of the item
    * value - is the frequency*/
    private HashMap<Integer, Integer> frequency;

    /*key - is the key of the item
    * value - is the value of the item*/
    private HashMap<Integer, Integer> values;

    /*key - is the frequency, which is the value in the count hashmap
    * value - is the list of keys with that frequency*/
    private HashMap<Integer, LinkedHashSet> lists;

    private int min = -1;
    private int capacity;

    public LFUCache(int capacity) {

        this.frequency = new HashMap<>();
        this.values = new HashMap<>();
        this.lists = new HashMap<>();

        this.lists.put(1, new LinkedHashSet<>());
        this.capacity = capacity;
    }

    public int get(int key) {

        if (! this.values.containsKey(key)){
            return -1;
        }

        int value = this.values.get(key);
        int freq = this.frequency.get(key);
        this.frequency.put(key, freq+1);

        this.lists.get(freq).remove(key);

        if (freq == this.min && this.lists.get(freq).size() == 0){
            this.min++;
        }

        if (!this.lists.containsKey(freq+1)){
            this.lists.put(freq+1, new LinkedHashSet<>());
        }

        this.lists.get(freq+1).add(key);
        return value;
    }

    public void put(int key, int value) {

        if (this.values.containsKey(key)){
            this.values.put(key, value);
            this.get(key);
            return;
        }

        if (this.values.size() >= this.capacity){

            Integer evictKey = (Integer) this.lists.get(this.min).iterator().next();
            this.lists.get(this.min).remove(evictKey);
            this.values.remove(evictKey);
            this.frequency.remove(evictKey);
        }

        this.values.put(key, value);
        this.frequency.put(key, 1);
        this.min = 1;
        this.lists.get(1).add(key);
    }
}
