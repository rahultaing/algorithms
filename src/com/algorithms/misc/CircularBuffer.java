// https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/

public class CircularBuffer{

    private int front = -1;
    private int rear = -1;
    private int[] nums;

    public CircularBuffer(int capacity){
        this.nums = new int[capacity];
    }

    public void enqueue(int val){

        if (front == 0 && rear == this.nums.length -1 || rear == front -1 ){
            // queue full
            return;
        }

        if (front == -1 && rear == -1){
            front = rear = 0;
            this.nums[rear] = val;
        }
        else if (rear == this.nums.length-1 && front!=0){
            rear = 0;
            this.nums[rear]= val;
        }
        else{
            rear++;
            this.nums[rear] = val;
        }
    }

    public int dequeue(){

        if (front == -1){
            // queue empty
            return -1;
        }

        int val = this.nums[front];
        this.nums[front] = -1;

        if (front == rear){
            // only 1 element
            front = -1;
            rear = -1;
        }
        else if (front == this.nums.length-1){
            front = 0;
        }
        else {
            front++; 
        }

        return val;
    }
}