package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> list = new ArrayList<>();
        Integer n = input.length();

        for (Integer i=0; i<n; i++){
            Character c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                String left = input.substring(0, i);
                String right = input.substring(i+1);

                List<Integer> leftList = this.diffWaysToCompute(left);
                List<Integer> rightList = this.diffWaysToCompute(right);

                for (Integer l: leftList) {
                    for (Integer r: rightList){

                        switch(c){
                            case '+':
                                list.add(l+r);
                                break;
                            case '-':
                                list.add(l-r);
                                break;
                            case '*':
                                list.add(l*r);
                                break;
                        }
                    }
                }
            }
        }

        if (list.size() == 0){
            list.add(Integer.valueOf(input));
        }

        return list;
    }
}
