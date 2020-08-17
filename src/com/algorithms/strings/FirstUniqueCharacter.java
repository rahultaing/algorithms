/*https://leetcode.com/problems/first-unique-character-in-a-string/solution/ */

class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c: s){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i=0; i<s.length; i++){
            if (map.get(c) == 1){
                return i;
            }
        }

        return -1;
    }
}