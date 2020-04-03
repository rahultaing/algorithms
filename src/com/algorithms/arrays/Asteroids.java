// https://leetcode.com/problems/asteroid-collision/solution/

public class Solution{

    private Stack<Integer> stack = new Stack<>();
    public int[] asteroidCollision(int[] asteroids) {
        
        stack.push(asteroids[0]);

        for (int i=1; i<asteroids.length; i++){
            collision:{
                while(!stack.isEmpty() && stack.peek()>0 && asteroids[i] < 0){
                    if (Math.abs(stack.peek()) < Math.abs(asteroids[i])){
                        stack.pop();
                    }
                    else{

                        // if values are same then they collide and both are dead.
                        // pop will end old asteroid - the one that is moving forward.
                         
                        if (Math.abs(stack.peek()) == Math.abs(asteroids[i])){
                            stack.pop();
                        }

                        // break collision will end new asteroid - the one that is moving backward.
                        break collision;
                    }
                }

                stack.push(asteroids[i]);
            }
        }

        int[] result = new int[stack.size()];
        int j = 0;
        while(!stack.isEmpty()){
            result[j] = stack.pop();
            j++;
        }

        return result;
    }
}