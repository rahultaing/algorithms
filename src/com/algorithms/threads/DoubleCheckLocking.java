import jdk.nashorn.internal.ir.ExpressionStatement;

public class ExpensiveObject{


}

public class Solution{

    // volatile keyword - tells jvm not to reorder object creation instructions
    // creating an empty object
    // assigning it to the variable
    // calling the constructor
    // these 3 operations can be performed by jvm in any order if volatile is not used.
    private volatile ExpensiveObject expensiveObject;

    public ExpensiveObject getExpensiveObject(){

        // first check is done to avoid multiple threads to block on syncronized block when the 
        // object is already initialized
        if (expensiveObject == null){
            synchronized(this){
                if (expensiveObject == null){
                    expensiveObject = new ExpensiveObject();
                }
            }
        }

        return expensiveObject;
    }
}