/**
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/12/
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *
 * 返回它的最大深度 3 。
 *
 */

public class TreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
 }
