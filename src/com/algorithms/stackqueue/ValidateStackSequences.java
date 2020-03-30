// https://leetcode.com/problems/validate-stack-sequences/solution/

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int j = 0;
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++){

            stack.push(pushed[i]);

            while (! stack.isEmpty() && j<n && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }

        return j==n;
    }
}