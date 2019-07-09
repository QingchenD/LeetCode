package ljava;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * number : 450
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 */

//TODO
public class TreeNodeDelete {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode parentNode = null;
        TreeNode node = root;
        while(node != null && node.val != key) {
            parentNode = node;
            if (key < node.val) node = parentNode.left;
            else node = parentNode.right;
        }

        if (node == null) return root; // not find, do nothing

        if (parentNode == null) {
            TreeNode leftNode;
            if (node.left != null) {
                leftNode = findBiggestTreeNode(node.left, node);
                root.val = leftNode.val;
            } else {
                root = node.right;
            }
        } else {
            if (node.left == null && node.right == null) {
                if (parentNode.left != null && parentNode.left.val == node.val) parentNode.left = null;
                else parentNode.right = null;
            } else {
                TreeNode leftNode;
                if (node.left != null) {
                    leftNode = findBiggestTreeNode(node.left, node);
                } else {
                    leftNode = node.right;
                }

                if (parentNode.left.val == node.val) parentNode.left = leftNode;
                else parentNode.right = leftNode;

                leftNode.right = node.right;
            }
        }

        return root;
    }

    /**
     *  左孩子要找右节点返回。
     * @param root
     * @return
     */
    public TreeNode findBiggestTreeNode(TreeNode root, TreeNode parent) {
        if (root == null) return null;
        if (root.right == null) return root;

        TreeNode parentNode = root;
        TreeNode node = parentNode.right;
        while (node.right != null) {
            parentNode = node;
            node = parentNode.right;
        }

        parentNode.right = null;
        return node;
    }

    public TreeNode findSmallestTreeNode(TreeNode root) {
        return null;
    }

    public ArrayList<String> wideFirst(TreeNode root) {
        if (root == null) return null;

        ArrayList<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.add(root);
        TreeNode node;
        while((node = queue.poll()) != null) {
            result.add(String.valueOf(node.val));
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return result;
    }
}
