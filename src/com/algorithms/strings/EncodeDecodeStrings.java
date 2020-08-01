package com.algorithms.strings;

import java.util.List;
/*https://leetcode.com/problems/encode-and-decode-strings/solution/
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

 

Note:

The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
*/
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