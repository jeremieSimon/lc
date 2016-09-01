package tree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest
 * path from the root node down to the farthest leaf node.
 */
public class MaxDepthOfBinTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public static int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(
            maxDepth(node.left, depth + 1),
            maxDepth(node.right, depth + 1));
    }
}
