// https://leetcode.com/problems/sentence-screen-fitting/discuss/90845/21ms-18-lines-Java-solution

public class Solution{

    public int sentence_screen_fitting(String[] sentence, int rows, int cols){

        String s = String.join(" ", sentence) + " ";
        int start = 0;
        int l = s.length();

        for (int i=0; i<rows; i++){

            start += cols;

            if (s.charAt(start%l) == ' '){
                start++;
            }
            else{

                while (start > 0 && (s.charAt((start-1)%l) == ' ')){
                    start--;
                }
            }
        }

        return start / l;
    }
}