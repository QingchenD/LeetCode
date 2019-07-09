package ljava;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * 316. 去除重复字母
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 *
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1:
 * 输入: "bcabc"
 * 输出: "abc"
 *
 * 示例 2:
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 */

public class RemoveDuplicateLetters {

    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了93.75%的用户
     * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了62.50%的用户
     */
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] ++;
        }

        boolean[] bExisted = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            count[ch - 'a']--;
            if (!bExisted[ch - 'a']) {
                while (!stack.isEmpty() && ch < stack.peek() && count[stack.peek() - 'a'] >= 1) {
                    bExisted[stack.pop() - 'a'] = false;
                }
                stack.push(ch);
                bExisted[ch - 'a'] = true;
            }
        }


        StringBuilder str = new StringBuilder();
        for (char ch : stack.toArray(new Character[0])) {
            str.append(ch);
        }
        return str.toString();
    }
}
