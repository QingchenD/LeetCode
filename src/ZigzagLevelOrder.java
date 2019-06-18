import java.util.*;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1027/
 *
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *      3
 *     / \
 *    9  20
 *       /  \
 *     15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight;
        //Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        int childCount = 0;
        int parentCount = 1;
        queue.add(root);
        leftToRight = true;
        List<Integer> sameLevel = new ArrayList<>();
        while (parentCount > 0) {
            TreeNode node = queue.poll();
            if (leftToRight) {
                sameLevel.add(node.val);
            } else {
                stack.push(node);
            }

            if (node.left != null) {
                queue.add(node.left);
                childCount ++;
            }
            if (node.right != null) {
                queue.add(node.right);
                childCount++;
            }

            parentCount--;

            if (parentCount == 0) {
                if (!leftToRight) {
                    while (stack.size() > 0) {
                        sameLevel.add(stack.pop().val);
                    }
                }
                result.add(sameLevel);
                sameLevel = new ArrayList<>();

                parentCount = childCount;
                childCount = 0;
                leftToRight = !leftToRight;
            }
        }
        return result;
    }
}
