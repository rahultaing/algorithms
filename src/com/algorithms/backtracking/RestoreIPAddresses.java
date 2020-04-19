package com.algorithms.backtracking;

// https://leetcode.com/problems/restore-ip-addresses/solution/
import java.util.List;

public class RestoreIPAddresses {

    private List<String> result = new ArrayList<>();
    List<Integer> dots = new ArrayList<>();

    public List<String> restore(String s){

        dots.add(0);
        this.backtrack(s);
        return result;
    }

    private void backtrack(String s){

        if (dots.size() == 4){
            if (! this.isValidSegment(dots.get(3), s.length(), s)) return;

            String ip = this.createValidIpAddress(s);
            result.add(ip);
            return;
        }

        int prev_pos = dots.get(dots.size()-1);

        for (int i = prev_pos+1; i<s.length(); i++){
            if (! this.isValidSegment(prev_pos, i, s)) return;

            dots.add(i);
            this.backtrack(s);
            dots.remove(dots.size()-1);
        }
    }

    private String createValidIpAddress(String s){

        StringBuilder sb = new StringBuilder(s);
        for (int i=3; i>=1; i--){

            sb.insert(dots.get(i), ".");
        }

        return sb.toString();
    }

    private boolean isValidSegment(Integer start, Integer end, String s){

        if (end-start > 3) return false;
        String segmentString = s.substring(start, end);

        if (segmentString.length()>1 && segmentString.charAt(0) == 0){
                return false;
        }
        
        return Integer.valueOf(segmentString) <= 255;
    }
}