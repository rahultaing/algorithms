package com.algorithms.strings;

import java.util.List;

public class EncodeDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    
        StringBuilder sb = new StringBuilder();

        for (String s: strs){

            sb.append(calcLength(s)).append(s);
        }

        return sb.toString();
    }

    /*return length of string as string - first 4 bytes*/
    private String calcLength(String s){

        int x = s.length();

        char[] b = new char[3];

        for (int i=3; i>=0; i--){

            b[3-i] = (char) (x >> (i*8) & 0xff);
        }

        return new String(b);
    }

    /*input is 4 bytes represented as string, output is int representation of those 4 bytes ~ 32 bits to represent integer */
    private int getLength(String s){

        int x = 0;
        
        for(char c: s.toCharArray()){

            x +=  (x << 8) + (int) c;
        }

        return x;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        int i = 0;

        List<String> res = new ArrayList<>();

        while (i<s.length()){

            int length = this.getLength(s.substring(i, i+4));
            i += 4;

            res.add(s.substring(i, i+length));
            i += length;
        }

        return res;
    }

}