// https://leetcode.com/problems/top-k-frequent-words/solution/

import java.util.HashMap;
import java.util.List;

public class Solution{

    public List<String> topK(String[] words, int k){
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (x,y) -> map.get(x) == map.get(y) ? x.compareTo(y) : 
                                    map.get(y) - map.get(x));

        return list.subList(0, k);
    }
}