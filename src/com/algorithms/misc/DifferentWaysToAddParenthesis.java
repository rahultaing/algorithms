import java.awt.List;
/* https://leetcode.com/problems/different-ways-to-add-parentheses/description/

Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10

*/
public class Solution{

    public List<Integer> compute(String input){

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<input.length(); i++){

            if (input.charAt(i) == '-' || input.charAt(i) == '+' || input.charAt(i) == '*'){
                List<Integer> leftPart = this.compute(input.substring(0, i));
                List<Integer> rightPart = this.compute(input.substring(i+1));

                for (Integer left: leftPart){
                    for (Integer right: rightPart){

                        char c = input.charAt(i);
                        int val = 0;
                        switch(c){
                            case '+':
                                val = left + right;
                                break;

                            case '-':
                                val = left - right;
                                break;

                            case '*':
                                val = left * right;
                                break;
                        }

                        result.add(val);
                    }
                }
            }
        }

        if (result.size() == 0){
            result.add(Integer.valueOf(input));
        }

        return result;
    }
}