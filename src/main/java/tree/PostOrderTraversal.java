package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 */
public class PostOrderTraversal {

    //go all left, then right, then middle
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "val = " + val;
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        } else {
            List<Integer> leftVals = postorderTraversal(root.left);
            List<Integer> rightVals = postorderTraversal(root.right);
            List<Integer> v = new ArrayList<>();
            v.addAll(leftVals);
            v.addAll(rightVals);
            v.add(root.val);
            return v;
        }
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        System.out.println(postorderTraversal(n1));
    }

}
