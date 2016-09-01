package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum,
 * find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class PathSumDepthFirstSearch {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (root == null) {
            return solutions;
        }
        return pathSum(root, new ArrayList<>(), sum, 0);
    }

    public static List<List<Integer>> pathSum(TreeNode n,
        List<Integer> path,
        int target,
        int currSum) {

        List<List<Integer>> solutions = new ArrayList<>();

        List<Integer> newPath = new ArrayList<>();
        for (int p: path) {
            newPath.add(p);
        }
        newPath.add(n.val);
        currSum += n.val;

        if (n.left == null && n.right == null && currSum == target) {
            solutions.add(newPath);
        } else {
            if (n.left != null) {
                solutions.addAll(pathSum(n.left, newPath, target, currSum));
            }
            if (n.right != null) {
                solutions.addAll(pathSum(n.right, newPath, target, currSum));
            }
        }

        return solutions;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;

        t3.left = t5;
        t3.right = t6;

        t6.left = t9;
        t6.right = t10;

        t4.left = t7;
        t4.right = t8;

        System.out.println(pathSum(t1, 22));
    }
}
