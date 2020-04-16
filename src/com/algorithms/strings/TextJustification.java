package com.algorithms.strings;

import java.util.List;
// https://leetcode.com/problems/text-justification/discuss/24902/Java-easy-to-understand-broken-into-several-functions

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth){

        int left = 0;
        List<String> result = new ArrayList<>();

        while (left < words.length){
            int right = this.findRight(left, words, maxWidth);
            result.add(this.justify(left, right, words, maxWidth));
            left = right+1;
        }

        return result;
    }

    private int findRight(int start, String[] words, int maxWidth){

        int right = start;
        int sum = words[right++].length();

        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth){

            sum += 1 + words[right++].length();
        }

        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth){

        if (left == right){
            return this.padResult(words[left], maxWidth);
        }

        boolean isLastLine = right == words.length-1 ? true: false;

        int wordCount = right - left;
        int totalSpace = maxWidth - wordLength(left, right, words);
        String space = isLastLine ? " " : blank(totalSpace/wordCount);
        int remainder = isLastLine ? 0 : totalSpace%wordCount;

        StringBuilder sb = new StringBuilder();
        for (int i=left; i<=right; i++){
            sb.append(words[i]).append(space).append(remainder-- > 0 ? " ": "");
        }

        return this.padResult(sb.toString().trim(), maxWidth);
    }

    private int wordLength(int start, int end, String[] words){

        int sum = 0;
        for (int i=start; i<=end; i++){
            sum += words[i].length();
        }

        return sum;
    }

    private String padResult(String input, int maxWidth){

        return input + this.blank(maxWidth - input.length());
    }

    private String blank(int length){

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<length; i++){
            sb.append(" ");
        }

        return sb.toString();
    }
}