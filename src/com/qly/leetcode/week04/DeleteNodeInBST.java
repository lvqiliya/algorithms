package com.qly.leetcode.week04;

/**
 * 450. 删除二叉搜索树中的节点
 *
 * @author qlylv
 */
public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            // 该点的左右子树都为空，直接删除无影响
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                // 右子树不为空，那么删除后继节点，然后用后继的值代替要删除的值
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                // 右子树为空，左子树不为空，此时后继节点是该节点的父节点，所以删除前驱节点，然后用前驱的值代替要删除的值
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    /**
     * 查找该节点的后继节点，从右子树遍历，直到找到子树中最深的左子节点
     * @param root
     * @return
     */
    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /**
     * 查找该节点的前驱节点，从左子树遍历，直到找到子树中最深的右子节点
     * @param root
     * @return
     */
    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
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
