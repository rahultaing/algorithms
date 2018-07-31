package com.algorithms.misc;

import java.util.Stack;

/*
* https://www.geeksforgeeks.org/the-stock-span-problem/
*
* The stock span problem is a financial problem where we have a series of
* n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum
number of consecutive days just before the given day, for which the price of the stock on
the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
*/
public class StockSpan {

    public void calculateSpan(int price[], int n, int S[]) {

        if (n == 0){
            return;
        }

        S[0] = 1;

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i=1; i<n; i++){

            while (! stack.isEmpty() && price[stack.peek()] <= price[i]){
                stack.pop();
            }

            S[i] = stack.isEmpty() ? i+1 : i-stack.peek();

            stack.push(i);
        }
    }
}
