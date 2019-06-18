/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 * 输入: [1,2,3]
 *   1
 *  / \
 * 2   3
 * 输出: 6
 *
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *
 *   -10
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * 输出: 42
 *
 */

public class MaxPathSum {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(null == root) return 0;
        subMaxPathSum(root);
        return max;
    }

    public int subMaxPathSum(TreeNode node)
    {
        if(null == node) return 0;
        int leftMax = Math.max(subMaxPathSum(node.left), 0);
        int rightMax = Math.max(subMaxPathSum(node.right), 0);
        max = Math.max(max, leftMax + rightMax + node.val);
        return Math.max(leftMax + node.val, rightMax + node.val);
    }
}
