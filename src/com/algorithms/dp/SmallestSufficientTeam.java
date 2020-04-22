package com.algorithms.dp;

import java.util.HashMap;
import java.util.Set;

// https://leetcode.com/problems/smallest-sufficient-team/discuss/334673/Java-Concise-Solution-24ms

public class SmallestSufficientTeam {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
    
        int ns = req_skills.length;
        int np = people.length;

        HashMap<String, Integer> skill_map = new HashMap<>();

        for (int i=0; i<ns; i++){
            skill_map.put(req_skills[i], i);
        }

        // a set array that holds min people required for a combination of skill
        Set<Integer>[] combination_skills = new Set[1<<ns];

        combination_skills[0] = new Set<>();

        for (int i=0; i<np; i++){

            int people_skill_code = 0;

            // generate code for this person
            for (String s : people.get(i)){
                people_skill_code |= (1<<skill_map.get(s));
            }

            // go through all combination skills
            for (int j=0; j<combination_skills.size(); j++){

                if (combination_skills[j] == null){
                    continue;
                }

                int combination_code = j|people_skill_code;

                if (combination_skills[combination_code]==null || 
                    combination_skills[combination_code].size() > combination_skills[j].size() + 1){

                        combination_skills[combination_code] = new Set<>(combination_skills[j]);
                        combination_skills[combination_code].add(i);
                }
            }
        }

        List<Integer> list = new ArrayList<>(combination_skills[(1<<ns) - 1]);
        return list;
    }

}