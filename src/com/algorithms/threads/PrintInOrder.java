// https://leetcode.com/problems/print-in-order/discuss/332890/Java-Basic-semaphore-solution-8ms-36MB

/*
Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

 

Example 1:

Input: [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
Example 2:
 */
import java.util.concurrent.Semaphore;

class Foo {

    Semaphore run2 = new Semaphore(0);
    Semaphore run3 = new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        try{
            printFirst.run();
        }
        finally{
            run2.release();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        run2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        try{
            printSecond.run();
        }
        finally{
            run3.release();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        run3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}