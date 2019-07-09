package ljava;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 */

public class GenerateParenthesis {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.89%的用户
     * 内存消耗 :37.5 MB, 在所有 Java 提交中击败了84.15%的用户
     *
     * 思路：
     * 1. 原来用Stack才容易判断的左右括号的有效性，用（rightCount < leftCount)来确定有效性。
     * 2. 有数组来实现回溯。链表或者队列也可以实现回溯，但是回溯的时候，需要删除末尾的数据。数据就没有这个问题，
     *    直接覆盖就可以了。另外字符串的长度时2n，所以使用数组也更好。
     */

    List<String> rst = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n < 1) return null;
        parenthesis(new char[2*n], n, 0, 0, 0);
        return rst;
    }

    private void parenthesis(char[] chars, int max, int index, int leftCount, int rightCount) {
        if (rightCount > leftCount || leftCount > max || rightCount > max) return;
        if (leftCount == max && rightCount == max) {
            rst.add(new String(chars));
            return;
        }

        chars[index] = '(';
        parenthesis(chars, max, index + 1, leftCount + 1, rightCount);

        chars[index] = ')';
        parenthesis(chars, max, index + 1, leftCount, rightCount + 1);
    }
}
