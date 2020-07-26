package com.algorithms.strings;

public class kmp {
    

    private int[] computeArray(char[] pattern){

        int j=0;
        int i=1;
        int n = pattern.length;
        int[] pa = new int[n];

        while (i<n){
            
            if (pattern[j] == pattern[i]){
                pa[i] = j+1;
                j++;
                i++;
            }
            else{

                if (j!=0){
                    j = pa[j-1];
                }
                else{
                    pa[i] = 0;
                    i++;
                }
            }
        }

        return pa;
    }

    public boolean isSubstring(char[] text, char[] pattern){

        int[] pa = this.computeArray(pattern);
        int i=0;
        int j=0;

        while (i<text.length && j<pattern.length){

            if (text[i] == pattern[j]){
                i++;
                j++;
            }
            else{

                if (j==0){
                    i++;
                }
                else{
                    j = pa[j-1];
                }
            }
        }

        if (j==pattern.length){
            return true;
        }

        return false;
    }
}