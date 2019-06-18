/**
 * https://leetcode-cn.com/explore/learn/card/binary-search/213/conclusion/851/
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 * 输入：16
 * 输出：True
 *
 * 示例 2：
 * 输入：14
 * 输出：False
 *
 */

public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        int lo = 1;
        int hi = num;
        int mid;
        long power;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            power = (long)mid * mid;
            if (num == power) return true;
            else if (power < num) lo = mid + 1;
            else hi = mid - 1;
        }

        return false;
    }
}
