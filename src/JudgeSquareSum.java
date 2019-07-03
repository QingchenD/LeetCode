/**
 * 633. 平方数之和
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 示例1:
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *
 * 示例2:
 * 输入: 3
 * 输出: False
 */

public class JudgeSquareSum {

    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了45.91%的用户
     * 内存消耗 :33.6 MB, 在所有 Java 提交中击败了81.88%的用户
     */
    public boolean judgeSquareSum(int c) {
        int sqrt = (int)Math.sqrt(c);
        int lo = 0;
        int hi = sqrt;
        while (lo <= hi) {
            int powSum = lo * lo + hi * hi;
            if (powSum == c) return true;
            else if (powSum < c) lo++;
            else hi--;
        }

        return false;
    }
}
