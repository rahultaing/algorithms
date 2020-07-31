package com.algorithms.arrays;
/*
https://leetcode.com/problems/pancake-sorting/
*/
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {

        int n = A.length;

        // in this example numbers are actually a permutation of 1..n
        int largest = n;

        List<Integer> res = new ArrayList<>();

        for (int i=0; i<n; i++){
            int index = find(A, largest);
            
            flip(A, index);
            flip(A, largest-1);

            res.add(index);
            res.add(largest);
        }
        return res;
    }   
    
    private int find(int[] A, int n){

        for (int i=0; i<A.length; i++){
            if (A[i] == n){
                return i;
            }
        }

        return -1;
    }

    private Void flip(int[] A, int index){

        int i=0;
        int j=index;

        while (i<j){
            int temp=A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}