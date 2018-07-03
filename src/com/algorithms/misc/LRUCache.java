package com.algorithms.misc;

import com.algorithms.common.DoublyNode;
import java.util.HashMap;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

*/
public class LRUCache {

    private DoublyNode head = new DoublyNode(0);
    private DoublyNode tail = new DoublyNode(0);
    private int capacity;
    private int count = 0;

    private HashMap<Integer, DoublyNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {

        DoublyNode node;
        if (!this.map.containsKey(key)){
            return -1;
        }

        node = this.map.get(key);

        this.deleteNode(node);
        this.addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {

        if (this.map.containsKey(key)){
            DoublyNode node = this.map.get(key);
            node.val = value;
            this.map.put(key, node);

            this.deleteNode(node);
            this.addToHead(node);
        }
        else{

            DoublyNode node = new DoublyNode(key, value);
            this.map.put(key, node);
            if (this.count < this.capacity){
                this.count++;
                this.addToHead(node);
            }
            else{
                this.map.remove(this.tail.prev.key);
                this.deleteNode(this.tail.prev);
                this.addToHead(node);
            }
        }
    }

    private void addToHead(DoublyNode node){

        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
        node.prev = head;
    }

    private void deleteNode(DoublyNode node){

        DoublyNode prev = node.prev;
        DoublyNode next = node.next;

        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;
    }
}
