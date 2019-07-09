package ljava;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/3/
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */

public class PostorderTraversal {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> result = new Stack<>();
            TreeNode node = root;

            stack.push(node);
            while (stack.size() > 0) {
                node = stack.pop();
                result.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }

            while(result.size() > 0) {
                list.add(result.pop().val);
            }
        }

        return list;
    }
}
