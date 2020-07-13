/*https://leetcode.com/problems/moving-average-from-data-stream/solution/

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

*/
import java.util.ArrayDeque;

public class MovingAverage {

    private int size;
    private int count;
    private ArrayDeque q = new ArrayDeque<>();
    private int sum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        this.count++;
        this.q.add(val);

        int first_val = this.count> this.size?this.q.poll():0;
        this.sum += (val - first_val);
        
        return (this.sum *1.0)/Math.min(size, count);
    }
}