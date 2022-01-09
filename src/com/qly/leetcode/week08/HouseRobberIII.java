package com.qly.leetcode.week08;

/**
 * 337. 打家劫舍 III
 *
 * @author qlylv
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] ans = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ans[1] = left[0] + right[0] + root.val;
        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
