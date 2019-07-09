package ljava;

/**
 * 264. 丑数 II
 * https://leetcode-cn.com/problems/ugly-number-ii/solution/
 *
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 */

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int i = 0;
        int i2 = 0, i3 = 0, i5 = 0;
        while (++i < n) {
            result[i] = Math.min(Math.min(2 * result[i2], 3 * result[i3]), 5 * result[i5]);
            if (2 * result[i2] <= result[i]) i2++;
            if (3 * result[i3] <= result[i]) i3++;
            if (5 * result[i5] <= result[i]) i5++;
        }

        return result[n - 1];
    }
}
