package com.qly.task.week04;

/**
 * 538. 把二叉搜索树转换为累加树
 * 解释说明
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * 解题思路
 * 由实例得知，二叉搜索树转换为累加树采用了逆中序遍历操作
 * 右子树
 * 先将右子节点和子根节点相加计算，并赋值给子根节点；
 * 再将子根节点和左子节点相加计算，并赋值给左子节点；
 * 然后将右子树最深的左子节点和根节点相加，并赋值给根节点，此时右子树遍历完成。
 * 左子树
 * 根节点和左子树最深的右子节点相加计算，并赋值给右子节点；
 * 重复右子树相加计算的逻辑即可完成转换。
 *
 * @author qlylv
 */
public class ConvertBSTToGreaterTree {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            // 递归找到最深的右子节点
            convertBST(root.right);
            // 计算最深的右子节点值，并完成赋值
            sum += root.val;
            root.val = sum;
            // 递归找到最深的左子节点
            convertBST(root.left);
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
