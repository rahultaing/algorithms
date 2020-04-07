import java.util.concurrent.Semaphore;

// https://leetcode.com/problems/the-dining-philosophers/discuss/411403/JAVA-Using-semaphores

class DiningPhilosophers {

    private Semaphore[] sema;
    public DiningPhilosophers() {
        for (int i=0; i<=4; i++){
            sema[i] = new Semaphore(1, true);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        

        Semaphore left = sema[philosopher];
        Semaphore right = sema[(philosopher+1)%4];

        if (philosopher%2==0){

            left.acquire();
            pickLeftFork.run();
            
            right.acquire();
            pickRightFork.run();
            
            eat.run();
            
            putLeftFork.run();
            left.release();
            
            putRightFork.run();
            right.release();
        }
        else{

            right.acquire();
            pickRightFork.run();
            
            left.acquire();
            pickLeftFork.run();
            
            eat.run();

            putRightFork.run();
            right.release();

            putLeftFork.run();
            left.release();
        }

    }
}