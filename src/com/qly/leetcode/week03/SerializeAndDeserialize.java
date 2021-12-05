package com.qly.leetcode.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * @author qlylv
 */
public class SerializeAndDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> seq = new ArrayList<>();
        dfs(seq, root);
        return String.join(",", seq);
    }

    private void dfs(List<String> seq, TreeNode root) {
        if (root == null) {
            seq.add("null");
            return;
        }
        seq.add(Integer.toString(root.val));
        dfs(seq, root.left);
        dfs(seq, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> seq = new LinkedList<>(Arrays.asList(data.split(",")));
        return restore(seq);
    }

    private TreeNode restore(List<String> seq) {
        if ("null".equals(seq.get(0))) {
            seq.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(seq.remove(0)));
        root.left = restore(seq);
        root.right = restore(seq);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
