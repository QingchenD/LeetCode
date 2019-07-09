package ljava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/9/
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */

public class TreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        int parentCount = 1;
        int childCount = 0;
        TreeNode node = root;
        List<Integer> l = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>() ;

        queue.add(root);

        while (queue.size() > 0) {
            node = queue.poll();
            l.add(node.val);
            parentCount--;

            if (node.left != null) {
                queue.add(node.left);
                childCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                childCount++;
            }

            if (parentCount == 0) {
                list.add(l);
                l = new ArrayList<>();
                parentCount = childCount;
                childCount = 0;
            }
        }

        return list;
    }
}
