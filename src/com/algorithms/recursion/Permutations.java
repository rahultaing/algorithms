package com.algorithms.recursion;

import com.algorithms.common.Utils;
import java.util.Arrays;

public class Permutations {

    public void permute(String s){

        int n = s.length();
        if (n == 0){
            return;
        }

        this.recurse(s.toCharArray(), 0, n);
    }

    private void recurse(char[] ar, int k, int n){
        if (k >= n){
            System.out.print(Arrays.toString(ar));
            return;
        }

        /*why is i going from k to n-1 instead of 0 to n-1*/
        for (Integer i=k; i<n; i++){
            Utils.swap(ar, i, k);
            this.recurse(ar, k+1, n);
            Utils.swap(ar, i, k);
        }
    }
}
