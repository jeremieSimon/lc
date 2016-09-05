package search;

import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * https://leetcode.com/problems/search-for-a-range/
 */
public class SearchForRange {

    public static int[] searchRange(int[] nums, int target) {
        int leftRange = leftRange(nums, target);
        if (leftRange == -1) {
            return new int[]{-1, -1};
        }
        return new int[] {leftRange, rightRange(nums, target)};
    }

    public static int rightRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        boolean wasFound = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                wasFound |= nums[mid] == target;
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return wasFound ? low - 1: -1;
    }

    public static int leftRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        boolean wasFound = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                wasFound |= nums[mid] == target;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return wasFound ? high + 1: -1;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,4,4,5,8,12,15,15,23,54}, 0)));
    }
}
