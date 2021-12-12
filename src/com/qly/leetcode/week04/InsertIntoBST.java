package com.qly.leetcode.week04;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * @author qlylv
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 递归边界
        if (root == null) {
            return new TreeNode(val);
        }
        // 递归逻辑
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
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
