package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

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
