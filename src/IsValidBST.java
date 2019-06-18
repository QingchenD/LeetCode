import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *    2
 *   / \
 *  1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *    5
 *   / \
 *  1   4
 *     / \
 *    3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *    根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {

    /**
     *  模拟中序遍历 ， 在中序遍历的时候判断是否有序:
     *  1. 节点只需要访问两边，节省时间。
     *  2. 遍历过程中，即可判断是否有序，不用遍历所有节点，同样也可节省时间。
     *
     *  拆箱装箱很耗费时间****
     */

    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (!isValidBST(root.left)) return false;

            if (pre >= root.val) return false;
            pre = root.val;

            if (!isValidBST(root.right)) return false;
        }
        return true;
    }

    private boolean isValidByMidOrder(TreeNode root, Integer pre) {
        if (root != null) {
            isValidByMidOrder(root.left, pre);
            if (pre == null) pre = root.val;
            else if (pre >= root.val) return false;
            isValidByMidOrder(root.right, pre);
        }
        return true;
    }

    /**
     *  先中序遍历， 遍历完了， 再判断list是否有序。
     *  但速度还不够快，相当于，每个节点至少要访问3遍：中序遍历两次，最后判断有序1次。
     */

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;

        List<Integer> list = new ArrayList<>();
        midOrderTraversal(root, list); //中序遍历二叉搜索树
        int size = list.size();
        int preInt = list.get(0);
        for (int i = 1; i < size; i++ ) {
            int integer = list.get(i);
            if (preInt >= integer) return false;
            preInt = integer;
        }

        return true;
    }

    /**
     * 不够快
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;

        List<Integer> list = new ArrayList<>();
        midOrderTraversal(root, list); //中序遍历二叉搜索树
        Iterator iterator = list.iterator();
        int preInt = (Integer)iterator.next();
        while (iterator.hasNext()) {
            int i = (Integer) iterator.next();
            if (preInt >= i) return false;
            preInt = i;
        }

        return true;
    }

    private List<Integer> midOrderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            midOrderTraversal(root.left, list);
            list.add(root.val);
            midOrderTraversal(root.right, list);
        }

        return list;
    }
}
