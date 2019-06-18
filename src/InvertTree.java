/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode l = root.left;
        root.left = root.right;
        root.right = l;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
