package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/
public class CombinationSum2 {

    private List<List<Integer>> outList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        this.backtrack(candidates, target, 0, new ArrayList<>());
        return this.outList;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> list){

        if (target < 0){
            return;
        }

        if (target == 0){
            this.outList.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++){

            if (i > start && candidates[i] == candidates[i-1]){
                continue;
            }

            list.add(candidates[i]);
            this.backtrack(candidates, target - candidates[i], i+1, list);
            list.remove(list.size()-1);
        }
    }
}
