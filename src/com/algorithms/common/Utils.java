package com.algorithms.common;

public class Utils {

    public static void swap(Integer[] nums, Integer i, Integer j){
        Integer temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void swap(char[] ar, int i, int j){
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void reverse(int[] nums, Integer l, Integer r){

        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void reverse(String s, Integer i, Integer j){

    }
}
