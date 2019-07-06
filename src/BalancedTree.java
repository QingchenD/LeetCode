/**
 * 110. 二叉平衡树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 */

public class BalancedTree {


    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了76.93%的用户
     * 内存消耗 :38.5 MB, 在所有 Java 提交中击败了47.45%的用户
     */

    /*
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1)
            result = false;
        return Math.max(l, r) + 1;
    }
     */



    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了76.93%的用户
     * 内存消耗 :38.3 MB, 在所有 Java 提交中击败了48.14%的用户
     */
    public boolean isBalanced(TreeNode root) {
        int[] depth = new int[1];
        return isBalanceTree(root, depth);
    }

    private boolean isBalanceTree(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] leftDepth = new int[1];
        int[] rightDepth = new int[1];
        if (isBalanceTree(root.left, leftDepth) &&
            isBalanceTree(root.right, rightDepth)) {

            if (Math.abs(leftDepth[0] - rightDepth[0]) <= 1) {
                depth[0] = 1 + Math.max(leftDepth[0], rightDepth[0]);
                return true;
            }
        }

        return false;
    }

}
