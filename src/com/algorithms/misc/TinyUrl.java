// https://leetcode.com/problems/encode-and-decode-tinyurl/solution/

import java.util.Random;

public class TinyUrl{

    private HashMap<String, String> map = new HashMap<>();
    private Random rand = new Random(0);
    private String alphabet = "0123..abc...ABC...";
    private String prefix = "http://tinyurl.com/";
    
    private String getRandom(){
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<6; i++){
            sb.append(alphabet.charAt(rand.nextInt(61)));
        }

        return sb.toString();
    }

    public String encode(String longurl){
        String key = this.getRandom();

        while (this.map.containsKey(key)){
            key = this.getRandom();
        }

        this.map.put(key, longurl);
        return this.prefix + key;
    }

    public String decode(String shorturl){

        return this.map.get(shorturl.replace(prefix, ""));
    }
}