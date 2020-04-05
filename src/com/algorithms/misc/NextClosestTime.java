// https://leetcode.com/problems/next-closest-time/discuss/107773/Java-AC-5ms-simple-solution-with-detailed-explaination

import java.util.Arrays;
import java.util.TreeSet;

public class Solution{

    public String nextClosestTime(String time){

        char[] res = time.toCharArray();

        Character[] digits = new Character[]{res[0], res[1], res[3], res[4]};
        TreeSet<Character> set = new TreeSet<>(Arrays.asList(digits));

        res[4] = findNext(res[4], '9', set);
        if (res[4] > time.charAt(4)){
            return String.valueOf(res);
        }

        res[3] = findNext(res[3], '5', set);
        if (res[3] > time.charAt(3)){
            return String.valueOf(res);
        }

        res[1] = findNext(res[1], res[0] == '2' ? '3' : '9', set);
        if (res[1] > time.charAt(1)){
            return String.valueOf(res);
        }

        res[0] = findNext(res[0], '2', set);
        return String.valueOf(res);
    }

    private Character findNext(Character c, Character limit, TreeSet<Character> set){

        // higher method in treeset is same as ceiling
        Character next = set.higher(c);
        return next == null || next > limit ? set.first() : next;
    }
}