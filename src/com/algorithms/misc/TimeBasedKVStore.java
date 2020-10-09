/*https://leetcode.com/problems/time-based-key-value-store/solution/
Create a timebased key-value store class TimeMap, that supports two operations.

1. set(string key, string value, int timestamp)

Stores the key and value, along with the given timestamp.
2. get(string key, int timestamp)

Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the one with the largest timestamp_prev.
If there are no values, it returns the empty string ("").

*/
public class TimeMap{

    private HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap(){
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){

        if (!this.map.containsKey(key)){
            this.map.put(key, new TreeMap<>());
        }

        TreeMap tree = this.map.get(key);
        tree.put(timestamp, value);
    }

    public String get(String key, int timestamp){

        if (!this.map.containsKey(key)){
            return "";
        }

        TreeMap tree = this.map.get(key);
        Integer floor = tree.floorKey(timestamp);
        return floor == null ? "" : tree.get(floor);
    }
}