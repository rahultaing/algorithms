// https://leetcode.com/problems/logger-rate-limiter/solution/

import java.util.HashSet;
import java.util.Queue;

public class solution{

    public class foo{
        String message;
        int timestamp;

        foo(int timestamp, String message){

        }
    }

    private Queue<foo> q = new LinkedList<>();
    private HashSet<String> set = new HashSet<>();

    public boolean shouldPrint(int timestamp, String message){

        while (q.size() != 0){
            if (q.peek().timestamp+10<timestamp){

                if (set.contains(q.peek().message)){
                    set.remove(q.peek().message);
                }

                q.remove();
            }
            else {
                break;
            }
        }

        if (set.contains(message)){
            return false;
        }

        foo f = new foo(timestamp, message);
        q.add(f);
        set.add(message);
        return true;
    }
}