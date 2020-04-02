package com.algorithms.binarysearch;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class MedianSortedArrays {

    public Double findMedian(Integer[] X, Integer[] Y){

        if (X.length > Y.length){
            return this.findMedian(Y, X);
        }

        Integer n = X.length;
        Integer m = Y.length;

        Integer lo = 0;
        Integer hi = n;

        while (lo <= hi){

            Integer partitionX = (lo + hi)/2;
            Integer partitionY = (n + m + 1)/2 - partitionX;

            Integer maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : X[partitionX - 1];
            Integer minRightX = partitionX == n ? Integer.MAX_VALUE : X[partitionX];

            Integer maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : Y[partitionY - 1];
            Integer minRightY = partitionY == m ? Integer.MAX_VALUE : Y[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX){
                if ((n+m)%2 == 0){
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0;
                }else{
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }
            else if (maxLeftX > minRightY){
                hi = partitionX - 1;
            }
            else if (maxLeftY > minRightX){
                lo = partitionX + 1;
            }
        }

        /*invalid input*/
        throw new IllegalArgumentException();
    }
}
