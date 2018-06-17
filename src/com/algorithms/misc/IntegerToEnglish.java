package com.algorithms.misc;

public class IntegerToEnglish {

    /*TODO: Fill these arrays completely*/
    private String[] lessThanTen = {"", "One", "Two", "Three", "Eight","Nine"};
    private String[] lessThanTwenty = {"Ten", "Eleven", "Twelve", "Nineteen"};
    private String[] lessThanHundred = {"Twenty", "Thirty", "Forty", "Ninety"};

    public String convert(Integer num){

        if (num == 0){
            return "Zero";
        }

        return this.helper(num);
    }

    private String helper(Integer num){
        if (num < 10){
            return this.lessThanTen[num];
        }
        else if (num < 20){
            return this.lessThanTwenty[num%10];
        }
        else if (num < 100){
            return this.lessThanHundred[num/10] + " " + this.lessThanTen[num%10];
        }
        else if (num < 1000){
            return this.helper(num/100) + " hundred " + this.helper(num%100);
        }
        else if (num < 1000000){
            return this.helper(num/1000) + " thousand " + this.helper(num%1000);
        }
        else if (num < 1000000000){
            return this.helper(num/1000000) + " million " + this.helper(num%1000000);
        }
        else {
            return this.helper(num/1000000000) + " billion " + this.helper(num%1000000000);
        }
    }
}
