import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/expressive-words/solution/

public class Solution{

    public int expressiveWords(String s, String[] words){

        RLE r = new RLE(s);

        int total=0;

        for (int i=0; i<words.length; i++){

            RLE r2 = new RLE(words[i]);

            if (r.key!=r2.key){
                continue;
            }
            
            int j=0;
            for (; j<r.counts.size(); i++){
                int c1 = r.counts.get(j);
                int c2 = r2.counts.get(j);

                if ((c1<3 && c1 != c2) || c2>c1){
                    break;
                }
            }

            if (j==r.counts.size()){
                total++;
            }
        }

        return total;
    }

    // run length encoding
    public class RLE{

        public String key;
        public List<Integer> counts;

        public RLE(String s){

            char[] ca = s.toCharArray();
            int n = s.length();
            counts = new ArrayList<>();
            int prev = -1;

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n; i++){

                if (ca[i]!=ca[i+1] || i==n-1){

                    sb.append(ca[i]);
                    counts.add(i-prev);
                    prev=i;
                }
            }

            key = sb.toString();
        }
    }
}