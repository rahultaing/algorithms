package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/description/

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

/*TODO: determine time complexity.*/

/*last practiced date: 7/7/2018*/
public class CombinationSum {

    private List<List<Integer>> outList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.recurse(candidates, new ArrayList<>(), target, 0);
        return this.outList;
    }

    private void recurse(int[] candidates,
            List<Integer> list, Integer target, Integer start){

        if (target < 0){
            return;
        }

        if (target == 0){
            this.outList.add(new ArrayList<>(list));
            return;
        }

        for (Integer i=start; i<candidates.length; i++){
            list.add(candidates[i]);
            recurse(candidates, list, target-candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
