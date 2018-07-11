package com.algorithms.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    /*cost is paid during enqueue operation otherwise
    both pop and top becomes expensive instead of just push being expensive.*/
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    /*redo this implementation*/
    public void push(int val){
        this.q1.add(val);
    }

    public int pop(){

        for (int i=0; i<this.q1.size(); i++){

            if (i!=this.q1.size()-1){
                this.q2.add(this.q1.poll());
            }
        }

        int val = this.q1.poll();
        Queue<Integer> temp = this.q1;
        this.q1 = this.q2;
        this.q2 = temp;

        return val;
    }

    public int top(){

    }
}
