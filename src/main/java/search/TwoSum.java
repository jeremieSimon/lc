package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Set<Integer>> numToCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!numToCount.containsKey(num)) {
                numToCount.put(num, new HashSet<>());
            }
            numToCount.get(num).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int need = target - num;
            if (numToCount.containsKey(need)) {
                List<Integer> indexes = new ArrayList<Integer>(numToCount.get(need));
                if (need != num) {
                    return new int[]{i, indexes.get(0)};
                } else if (indexes.size() > 1) {
                    int notI = 0;
                    for (int index: indexes) {
                        if (index != i) notI = index;
                    }
                    return new int[]{i, notI};
                }
            }
        }
        return null;
    }
}
