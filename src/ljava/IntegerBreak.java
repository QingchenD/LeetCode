package ljava;

/**
 * 343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */

public class IntegerBreak {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了87.34%的用户
     * 内存消耗 :34.2 MB, 在所有 Java 提交中击败了13.93%的用户
     */
    public int integerBreak2(int n) {
        if(n == 2 || n == 3) return n-1;
        int res = 1;
        while(n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }


    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了87.34%的用户
     * 内存消耗 :34 MB, 在所有 Java 提交中击败了14.67%的用户
     */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int div = n / 3;
        int mod = n % 3;
        int result;
        if (mod == 0) {
            result = (int) Math.pow(3, div);
        } else if (mod == 1) {
            result = (int)Math.pow(3, div - 1) * 4;
        } else {
            result = (int)Math.pow(3, div) * mod;
        }

        return result;
    }
}
