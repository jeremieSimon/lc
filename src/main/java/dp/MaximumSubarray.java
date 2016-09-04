package dp;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int local = -10_000;
        int abs = -10_000;
        for (int num: nums) {
            if (num > (local + num)) {
                local = num;
            } else {
                local += num;
            }
            if (local > abs) {
                abs = local;
            }
        }
        return abs;
    }
}
