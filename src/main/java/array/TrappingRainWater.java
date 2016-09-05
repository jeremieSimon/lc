package array;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 */
public class TrappingRainWater {

    public static int trap(int[] height) {
        int[] greaterPredecessors = greaterPredecessors(height);
        int[] greaterSuccessors = greaterSuccessor(height);
        int trappedWater = 0;

        for (int i = 0; i < height.length; i++) {
            int lowerWall = Math.min(greaterPredecessors[i], greaterSuccessors[i]);
            trappedWater += Math.max(0, lowerWall - height[i]);
        }

        return trappedWater;
    }

    public static int[] greaterSuccessor(int[] height) {
        int[] greaterSuccessors = new int[height.length];
        int max = 0;
        for (int h = height.length - 1; h >= 0; h--) {
            int val = height[h];
            greaterSuccessors[h] = max;
            if (max <= val) {
                max = val;
            }
        }
        return greaterSuccessors;
    }

    public static int[] greaterPredecessors(int[] height) {
        int[] greaterPredecessors = new int[height.length];
        int max = 0;
        for (int h = 0; h < height.length; h++) {
            int val = height[h];
            greaterPredecessors[h] = max;
            if (max < val) {
                max = val;
            }
        }
        return greaterPredecessors;
    }

    public static void main(String[] args) {
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(h));
    }
}
