package ljava;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/247/bonus/1045/
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 */

public class MySqrt {
    public int mySqrt(int x) {
        if (x < 1) return 0;
        if (x == 1) return 1;

        int lo = 1;
        int hi = x;
        int mid;
        int sqrt = 1;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (x / mid < mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
                sqrt = mid;
            }
        }

        return sqrt;
    }

    public int mySqrt2(int x) {
        if (x < 1) return 0;
        if (x == 1) return 1;

        int lo = 1;
        int hi = x;
        int mid = lo + (hi - lo) / 2;
        while (lo < hi) {
            if (x / mid < mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
            mid = lo + (hi - lo) / 2;
        }

        return hi - 1;
    }
}
