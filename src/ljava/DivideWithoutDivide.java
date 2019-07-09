package ljava;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 *
 * 说明:
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 */

public class DivideWithoutDivide {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (divisor == Integer.MIN_VALUE) return 0;

        int dividendFlag = dividend > 0 ? 1 : -1;
        int divisorFlag = divisor > 0 ? 1 : -1;
        int usDividend = dividendFlag * dividend;
        int usDivisor = divisor * divisorFlag;
//
//        int lo = 0 , hi = 31;
//        int mid = (lo + hi) >> 1;
//        while (lo < hi) {
//            if (Math.abs(usDividend >> mid) < usDivisor) {
//                hi = mid - 1;
//            } else if (Math.abs(usDividend >> mid) > usDivisor) {
//                lo = mid + 1;
//            } else {
//                break;
//            }
//            mid = ((lo + hi) >> 1) + (lo + hi) % 2 ;
//
//        }

        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ( Math.abs(usDividend >> i) >= usDivisor) {
                if (i == 31) {
                   result = (dividendFlag * divisorFlag > 0) ?  Integer.MAX_VALUE : Integer.MIN_VALUE;
                   return result;
                }

                result += 1 << i;
                usDividend = Math.abs(usDividend) - (usDivisor << i);
            }
        }

        // Math.abs(Integer.MIN_VALUE) equals Integer.MIN_VALUE  < 0
        if (Math.abs(usDividend) < 0) {
            result += 1;
        }

        return dividendFlag * divisorFlag * result;
    }
}
