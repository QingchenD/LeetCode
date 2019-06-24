/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 */


public class NumDecodings {

    /**
     * F(n) = flag1 * F(n - 1) + flag2 * f(n - 2);
     * flag1 = s.[n - 1] is char ? 1 : 0;
     * flag2 = s[n-2, n -1] is char ? 1 : 0;
     *
     * 初始化条件:
     * F(0) = 1;
     * F(1) = S[0] is char ? 1 : 0;
     *
     * 执行用时 :3 ms, 在所有 Java 提交中击败了85.81%的用户
     * 内存消耗 :34.6 MB, 在所有 Java 提交中击败了45.15%的用户
     *
     * 总结： 全部使用s.charAt(0)替换s.substring()函数， 时间可以减少一半多。
     * subString()是比较重的操作。
     */

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int[] count = new int[s.length() + 1];
        count[0] = 1;
        count[1] = 1;
        int count1, count2;
        for (int i = 1; i < s.length(); i++) {
            count1 = s.charAt(i) != '0' ? count[i] : 0;
            if (s.charAt(i - 1) != '0') {
                int value = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
                count2 = value >= 1 && value <= 26 ? count[i - 1] : 0;
            } else {
                count2 = 0;
            }
            count[i + 1] = count1 + count2;
        }

        return count[count.length - 1];
    }

    /**
     * F(n) = flag1 * F(n - 1) + flag2 * f(n - 2);
     * flag1 = s.[n - 1] is char ? 1 : 0;
     * flag2 = s[n-2, n -1] is char ? 1 : 0;
     *
     * 初始化条件:
     * F(0) = 1;
     * F(1) = S[0] is char ? 1 : 0;
     *
     * leetcode : 7ms 超过22.65%用户
     */
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0 || !isValid(s, 0, 0)) return 0;

        int[] count = new int[s.length() + 1];
        count[0] = 1;
        count[1] = 1;
        int count1, count2;
        for (int i = 1; i < s.length(); i++) {
            count1 = isValid(s, i, i) ? count[i] : 0;
            count2 = isValid(s, i - 1, i)? count[i - 1] : 0;
            count[i + 1] = count1 + count2;
        }

        return count[count.length - 1];
    }

    private boolean isValid(String s, int start, int end) {
        if (s.charAt(start) == '0') return false;
        int value = Integer.valueOf(s.substring(start, end +1));
        return  (value >= 1 && value <= 26);
    }
}
