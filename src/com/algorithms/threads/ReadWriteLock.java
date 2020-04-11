// https://www.youtube.com/watch?v=7VqWkc9o7RM

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Solution{

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public void write(){
        try{
            writeLock.lock();
        }
        finally{
            writeLock.unlock();
        }
    }

    public void read(){

        try{

            readLock.lock();
        }finally{

            readLock.unlock();
        }
    }
}