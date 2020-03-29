// example to show use of synchronized construct in java

public class Solution{

    private int sharedVariable;

    public synchronized void synchronized_increment(){
        sharedVariable++;
    }

    public synchronized void synchronized_decrement(){
        sharedVariable--;
    }

    public void synchronized_block_increment(){

        // do some non critical section work here
        int non_shared_variable = 10;
        non_shared_variable++;

        synchronized(this){
            sharedVariable++;
        }
    }

    public void synchronized_block_decrement(){
        // do some non critical section work here
        int non_shared_variable = 10;
        non_shared_variable--;

        synchronized(this){
            sharedVariable--;
        }
    }
}