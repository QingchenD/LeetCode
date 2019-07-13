package ljava;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/interview/2/
 *
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 * 示例 1:
 * 输入: [1,3,null,null,2]
 *    1
 *   /
 *  3
 *   \
 *    2
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 */
public class RecoverTree {
    public void recoverTree(TreeNode root) {
        if (root == null) return;

        List<TreeNode> list = new ArrayList<>();
        inorderTraversal(root, list);

        int first = -1;
        int second = -1;
        for (int i = 0; i < list.size(); i++) {
            if (first == -1) {
                if (list.get(i).val > list.get(i + 1).val) {
                    first = i;
                }
            } else if (second == -1 || second == (first + 1)) {
                if (list.get(i).val < list.get(i - 1).val) {
                    second = i;
                }
            }
        }

        int tmp = list.get(first).val;
        list.get(first).val = list.get(second).val;
        list.get(second).val = tmp;
        return;
    }

    private List<TreeNode> inorderTraversal(TreeNode root, List<TreeNode> list) {
        if(root != null) {
            inorderTraversal(root.left, list);
            list.add(root);
            inorderTraversal(root.right, list);
        }

        return list;
    }

}
