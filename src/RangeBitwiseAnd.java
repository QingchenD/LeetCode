/**
 * 201. 数字范围按位与
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 *
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 示例 1: 
 * 输入: [5,7]
 * 输出: 4
 *
 * 示例 2:
 * 输入: [0,1]
 * 输出: 0
 *
 */

public class RangeBitwiseAnd {

    /**
     * 执行用时 :31 ms, 在所有 Java 提交中击败了97.25%的用户
     * 内存消耗 :35.3 MB, 在所有 Java 提交中击败了75.00%的用户
     *
     * 算法：
     * 1. 如果N超过M的两倍，说明完全右移了一位，则M的所有为都会与0想与，所以最后结果为0。
     * 2. m 和 N 高位相同的部分，不会变化，所以在做与运算时也不会变化。找出N中所有不为1的位，且刚好小于M的第一个数。
     *    就是与运算的结果。
     */
    public int rangeBitwiseAnd(int m, int n) {
        if ((n >> 1) > m) return 0;

        while (n > m) {
            n &= (n-1);
        }

        return n;
    }




    /**
     * 执行用时 :36 ms, 在所有 Java 提交中击败了36.36%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了8.34%的用户
     *
     * 用二分查抄的方法，找中间的位置，最多5次就可以锁定位置，但并没有比纯左移的方式快。
     * 可能原因：二分查找循环内的运算比较多，抵消了因为减少循环次数二带来的优势
     */
    public int rangeBitwiseAnd3(int m, int n) {
        if ((n >> 1) > m) return 0;

        int lo = 0;
        int hi = 30;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            int and = Integer.MAX_VALUE << mid;
            if ((and & m) < (and & n)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return m & (Integer.MAX_VALUE << lo);
    }


    /**
     * 执行用时 :32 ms, 在所有 Java 提交中击败了91.74%的用户
     * 内存消耗 :37.5 MB, 在所有 Java 提交中击败了7.64%的用户
     */
    public int rangeBitwiseAnd2(int m, int n) {
        if ((n >> 1) > m) return 0;

        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }

        return m << count;
    }


    /**
     * 执行用时 :36 ms, 在所有 Java 提交中击败了36.36%的用户
     * 内存消耗 :37 MB, 在所有 Java 提交中击败了9.03%的用户
     */
    public int rangeBitwiseAnd1(int m, int n) {
        if ((n >> 1) > m) return 0;
        int and = Integer.MAX_VALUE;
        for (long i = m; i <= n; i++) {
            and &= i;
            if (and == 0) break;
        }

        return and;
    }
}
