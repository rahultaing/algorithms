package com.algorithms.misc;


/*

https://leetcode.com/problems/find-median-from-data-stream/description/
Median is the middle value in an ordered integer list. If the size of the list is even,
there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

Example:

    addNum(1)
    addNum(2)
    findMedian() -> 1.5
    addNum(3)
    findMedian() -> 2

*/

import java.util.PriorityQueue;

public class MedianFromDataStream {

    private NegativeComparator comparator = new NegativeComparator();
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private PriorityQueue<Integer> small = new PriorityQueue<>(comparator);

    public void addNum(int num) {
        large.add(num);

        small.add(large.poll());

        if (small.size() > large.size()){
            large.add(small.poll());
        }
    }

    public double findMedian() {

        if (large.size() == small.size() && large.size() > 0){
            return (large.peek() + small.peek())/2.0;
        }

        return large.size() == 0 ? 0 : large.peek();
    }

}
