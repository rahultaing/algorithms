package com.algorithms.stackqueue;

import java.util.Stack;

public class ImplementQueueUsingStack {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int val){

        this.s1.push(val);

        while(!this.s2.isEmpty()){
            this.s1.push(this.s2.pop());
        }

        Stack<Integer> temp = this.s2;
        this.s2 = this.s1;
        this.s1 = temp;
    }

    public int dequeue(){
        return this.s2.pop();
    }

    public int peek(){
        return this.s2.peek();
    }
}
