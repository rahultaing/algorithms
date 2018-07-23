package com.algorithms.misc;

import com.algorithms.common.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*

https://leetcode.com/problems/flatten-nested-list-iterator/description/

* Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].


*/
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {

        int n = nestedList.size();

        for (int i=n-1; i>=0; i--){
            this.stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return this.stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        if (this.stack.isEmpty()){
            return false;
        }

        while(true){
            NestedInteger nestedInteger = this.stack.peek();

            if (nestedInteger.isInteger()){
                break;
            }

            this.stack.pop();

            List<NestedInteger> list = nestedInteger.getList();

            int n = list.size();

            for (int i = n-1; i >= 0; i--){
                this.stack.push(list.get(i));
            }
        }

        return true;
    }
}
