package com.algorithms.math;

import java.util.HashMap;

/*

https://leetcode.com/problems/max-points-on-a-line/description/

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6

*/
public class MaxPointsOnLine {

    public int maxPoints(Point[] points) {

        int n = points.length;

        if (n < 2){
            return n;
        }

        int result = 0;


        for (int i = 0; i < n; i++){

            int overlap = 0;
            HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
            int max = 0;

            for (int j = i+1; j < n; j++){

                if (points[j].x == points[i].x && points[j].y == points[i].y){
                    overlap++;
                    continue;
                }

                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;

                int gcd = this.generateGCD(x, y);

                if (gcd != 0) {
                    x = x / gcd;
                    y = y / gcd;
                }

                if (map.containsKey(x)){

                    HashMap<Integer, Integer> innerMap = map.get(x);

                    if (innerMap.containsKey(y)) {

                        innerMap.put(y, innerMap.get(y) + 1);
                    }
                    else{

                        innerMap.put(y , 1);
                    }
                }
                else{

                    HashMap<Integer, Integer> innerMap = new HashMap<>();
                    innerMap.put(y, 1);
                    map.put(x, innerMap);
                }

                max = Math.max(max, map.get(x).get(y));
            }

            result = Math.max(result, max + overlap + 1);
        }

        return result;
    }

    private int generateGCD(int a, int b){
        if (b == 0){
            return a;
        }

        return this.generateGCD(b, a%b);
    }
}
