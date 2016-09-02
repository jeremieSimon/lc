package tree;


/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST. *
 */
public class SortedArrayToBST {

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return toBst(nums, 0, nums.length - 1);
    }

    public static TreeNode toBst(int[] nums, int low, int hi) {
        if (low > hi) return null;

        int mid = (low + hi) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = toBst(nums, low, mid - 1);
        node.right = toBst(nums, mid + 1, hi);
        return node;
    }
}
