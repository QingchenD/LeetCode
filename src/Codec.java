import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 * 你可以将以下二叉树：
 *    1
 *   / \
 *  2   3
 *     / \
 *    4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 提示: 
 * 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 */

public class Codec {


    /**
     * 执行用时 :34 ms, 在所有 Java 提交中击败了54.22%的用户
     * 内存消耗 :46.9 MB, 在所有 Java 提交中击败了59.90%的用户
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;

        LinkedList<TreeNode> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            list.add(node);
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        //删除末尾重复的null
        while (list.size() > 2) {
            TreeNode last = list.pollLast();
            TreeNode preLast = list.pollLast();
            if (last != null || preLast != null) {
                list.add(preLast);
                list.add(last);
                break;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (TreeNode node : list) {
            if (node != null) {
                builder.append(node.val);
            } else {
                builder.append("null");
            }
            builder.append(",");
        }
        builder.setCharAt(builder.length() - 1, ']');
        return builder.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 2) return null;

        String[] strs = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        queue.add(root);
        for (int i = 1; i < strs.length - 1; i += 2) {
            TreeNode node = queue.poll();

            if (!strs[i].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(strs[i]));
                queue.add(node.left);
            }

            if (!strs[i + 1].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(strs[i + 1]));
                queue.add(node.right);
            }
        }

        return root;
    }
}
