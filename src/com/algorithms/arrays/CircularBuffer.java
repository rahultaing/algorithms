package com.algorithms.arrays;

/*
* https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
*
* Circular Queue is a linear data structure in which the operations are performed based
* on FIFO (First In First Out) principle and the last position is connected back to the
* first position to make a circle. It is also called ‘Ring Buffer’.*/
public class CircularBuffer {

    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    public CircularBuffer(int size){
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
        this.capacity = size;
    }

    public void enqueue(int val) throws Exception{

        // queue full scenario
        if ((front==0 && rear==capacity-1) || (rear == (front-1)%(capacity-1))){
           throw new Exception("Buffer full");
        }

        if (front == -1){
            // queue empty scenario
            front++;
            rear++;
            arr[front] = val;
        }
        else if (rear < capacity-1){
            // normal scenario, simply keep adding items at the end
            rear++;
            arr[rear] = val;
        }
        else if (rear == capacity-1 && front != 0){
            // scenario where rear has reached end but items have been dequeued from front.
            rear = 0;
            arr[rear] = val;
        }
    }

    public int dequeue() throws Exception{

        // queue empty case
        if (front == -1){
            throw new Exception("Buffer empty");
        }

        int val = arr[front];
        arr[front] = -1;

        if (front == rear){
            // queue has only one element case
            front = -1;
            rear = -1;
        }
        else if(front == capacity-1){
            // front at end of array case
            front = 0;
        }
        else{
            // default case
            front++;
        }

        return val;
    }
}
