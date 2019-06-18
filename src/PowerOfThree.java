/**
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/25/math/62/
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 * 输入: 27
 * 输出: true
 *
 * 示例 2:
 * 输入: 0
 * 输出: false
 *
 * 示例 3:
 * 输入: 9
 * 输出: true
 *
 * 示例 4:
 * 输入: 45
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 */

public class PowerOfThree {


    public boolean isPowerOfThree(int n) {
        //   2 ^ 31 = 2147483648 , 3 ^ 19 = 1162261467
        return (n >= 1 && 1162261467 % n == 0);
    }


    public boolean isPowerOfThree3(int n) {

        int[] threePower = new int[] {1, 3, 9, 27, 81, 243, 729,
                                        2187, 6561, 19683, 59049, 177147, 531441, 1594323,
                                        4782969, 14348907, 43046721, 129140163, 387420489, 1162261467}; //   2 ^ 32 = 4294967296 , 3 ^ 20 = 3486782401
        int lo = 0;
        int hi = threePower.length - 1; //   2 ^ 31 = 2147483648 , 3 ^ 19 = 1162261467
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            if (threePower[mid] == n) return true;
            else if (threePower[mid] < n) lo = mid + 1;
            else hi = mid - 1;
        }

        return false;
    }

    public boolean isPowerOfThree2(int n) {
        int lo = 0;
        int hi = 19; //   2 ^ 31 = 2147483648 , 3 ^ 19 = 3486782401
        int mid;
        long power;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            power = (long)Math.pow(3, mid);
            if (power == n) return true;
            else if (power < n) lo = mid + 1;
            else hi = mid - 1;
        }

        return false;
    }
}
