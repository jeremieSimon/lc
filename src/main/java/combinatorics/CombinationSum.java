package combinatorics;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/combination-sum/
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates,
            new ArrayList<Integer>(), 0, candidates.length - 1, 0, target);
    }

    static List<List<Integer>> combinationSum(int[] candidates,
        List<Integer> sequence,
        int from,
        int to,
        int runningSum,
        int target) {

        List<List<Integer>> solutions = new ArrayList<>();
        if (runningSum == target) {
            solutions.add(sequence);
            return solutions;
        }

        for (int i = from; i <= to; i++) {
            if (runningSum + candidates[i] > target) {
                continue;
            }
            List<Integer> newSeq = new ArrayList<>(sequence);
            newSeq.add(candidates[i]);
            solutions.addAll(combinationSum(candidates, newSeq, i, to, runningSum + candidates[i], target));
        }
        return solutions;
    }
}
