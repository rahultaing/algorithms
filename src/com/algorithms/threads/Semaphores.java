import java.util.concurrent.Semaphore;

// example to show use of semaphore to make a critical section thread safe

public class Solution{

    private Semaphore semaphore = new Semaphore(1);
    
    // ensures oldest thread will acquire the semaphore
    private Semaphore fair_semaphore = new Semaphore(1, true);

    private int sharedVariable;
    
    public void increment(){
        semaphore.acquire();
        
        try{
            sharedVariable++;
        }
        finally{
            semaphore.release();
        }
    }

    public void decrement(){
        semaphore.acquire();
        
        try{
            sharedVariable--;
        }
        finally{
            semaphore.release();
        }
    }
}