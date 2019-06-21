import javax.security.auth.login.AccountExpiredException;
import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */


public class Flatten {
    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了40.38%的用户
     * 内存消耗 :36.5 MB, 在所有 Java 提交中击败了80.92%的用户
     */
    private List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if (root == null) return;

        preorderTraversal(root);
        TreeNode pre = null;
        for (TreeNode node : list) {
            if (pre == null) pre = node;
            else {
                pre.left = null;
                pre.right = node;
                pre = node;
            }
        }
    }

    private List<TreeNode> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        return list;
    }
}
