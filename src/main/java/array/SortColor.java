package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 */
public class SortColor {

    public static void sortColors(int[] nums) {
        int index0 = -1;
        int index2 = nums.length;
        if (nums.length == 0 || nums.length == 1) return;
        sortColors(nums, index0, index2, 0);
    }

    public static void sortColors(int[] nums, int index0, int index2, int curr) {
        while (curr < Math.min(nums.length, index2)) {
            if (nums[curr] == 2) { // switch
                index2--;
                int tmp = nums[index2];
                nums[index2] = nums[curr];
                nums[curr] = tmp;
            }
            if (nums[curr] == 0) {
                if (curr == index0) {
                    curr++;
                    continue;
                }
                index0++;
                int tmp = nums[index0];
                nums[index0] = nums[curr];
                nums[curr] = tmp;
            }
            if (nums[curr] == 1) {
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
