/**
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/13/
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *    1
 *   / \
 *  2   2
 *  \   \
 *  3    3
 *
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return symmetricChild(root.left, root.right);
    }

    private boolean symmetricChild(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;

        return (left.val == right.val) && symmetricChild(left.left, right.right)
                && symmetricChild(left.right, right.left);
    }
}
