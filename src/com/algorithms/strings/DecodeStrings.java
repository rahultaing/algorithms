// https://leetcode.com/submissions/detail/119404639/

import java.util.Stack;

public class Solution{

    public String decodeString(String s){

        int i = 0;
        int n = s.length();

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stack = new Stack<>();

        
        stack.push("");

        while (i < n){

            if (Character.isDigit(s.charAt(i))){

                int j = i;
                while (j+1<n && Character.isDigit(j+1)){
                    j++;
                }
                
                String val = s.substring(i, j+1);
                countStack.push(Integer.valueOf(val));
            }
            else if (s.charAt(i) == '['){
                stack.push("");
            }
            else if (s.charAt(i) == ']'){

                int count = countStack.pop();
                String val = stack.pop();
                StringBuilder sb = new StringBuilder();
                for (int k=0; k<count; k++){
                    sb.append(val);
                }

                stack.push(stack.pop() + sb.toString());
            }
            else{
                stack.push(stack.pop() + s.charAt(i));
            }

            i++;
        }

        return stack.pop();
    }
}