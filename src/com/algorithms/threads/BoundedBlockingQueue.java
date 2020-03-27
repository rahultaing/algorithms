import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class myQueue{

    private ReentrantLock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    private int[] ar;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public myQueue(int capacity){

        ar = new int[capacity];
    }

    public void enqueue(int val){
        lock.lock();

        try{

            while (size == ar.length){
                full.await();
            }

            ar[tail++] = val;
            tail %= ar.length;
            size++;
            empty.signal();
        }
        finally{
            lock.unlock();
        }
    }

    public int dequeue(){

        lock.lock();

        try{

            while (size == 0){
                empty.await();
            }

            int val = ar[head++];
            head %= ar.length;
            size--;
            full.signal();
            return val;
        }
        finally{
            lock.unlock();
        }
    }
}