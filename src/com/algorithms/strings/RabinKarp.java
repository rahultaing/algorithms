package com.algorithms.strings;

// linear time pattern matching
// worst case M (pattern length) * N (text length)
// https://algs4.cs.princeton.edu/53substring/RabinKarp.java.html

public class RabinKarp {

    // length of pattern 
    int m;

    // large prime number
    int q = 997;

    // precompute r^(m-1)
    int rm; 

    // length of character set
    int r = 256;

    String pat;

    public int match(String pat, String text){

        m = pat.length();
        this.pat = pat;

        rm = 1;
        for (int i=1; i<m; i++){
            rm = (r * rm) % q;
        }

        int pat_hash = this.hash(pat, 0);
        int text_hash = this.hash(text, m);

        if (pat_hash == text_hash && this.check(text, 0)){
            return 0;
        }
        
        for (int i=m; i<text.length(); i++){

            text_hash = (text_hash - (rm * text.charAt(i-m)) % q)%q;
            text_hash = (text_hash * r + text.charAt(i)) % q;

            int offset = i-m+1;

            if (text_hash == pat_hash && check(text, offset)){
                return offset;
            }
        }

        return -1;
    }

    private int hash(String s, int till_offset){

        int val = 0;
        for (int i=0; i < till_offset; i++){
            val = (val * r + s.charAt(i)) % q;
        }

        return val;
    }

    private boolean check(String text, int offset){
        for (int i=0; i<m; i++){
            if (pat.charAt(i) != text.charAt(i+offset)){
                return false;
            }
        }

        return true;
    }
}