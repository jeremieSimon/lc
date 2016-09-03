package combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * Given a set of distinct integers, nums, return all possible subsets.
 */
public class Subset {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        int[] bits = new int[nums.length];
        int i = 0;

        while (i < Math.pow(2, nums.length)) {
            next(bits);
            solutions.add(asSubset(bits, nums));
            i++;
        }
        return solutions;
    }

    static void next(int[] bits) {
        int i = bits.length - 1;
        while (i >= 0) {
            if (bits[i] == 0) {
                bits[i] = 1;
                return;
            }
            if (bits[i] == 1) {
                bits[i] = 0;
            }
            i--;
        }
    }

    static List<Integer> asSubset(int[] bits, int[] nums) {
        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                subset.add(nums[i]);
            }
        }
        return subset;
    }
}
