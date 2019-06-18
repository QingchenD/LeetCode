/**
 * https://leetcode-cn.com/problems/power-of-four/
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 * 输入: 16
 * 输出: true
 *
 * 示例 2:
 * 输入: 5
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 */

public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        if (num == 0 || (num & (num - 1)) != 0) return false;
        return (num & 0xAAAAAAAA) == 0;
    }

    // slowly
    public boolean isPowerOfFour2(int num) {
        int lo = 0;
        int hi = 15;
        int mid;
        long power;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            power = (long)Math.pow(4, mid);
            if (power == num) return true;
            else if (power < num) lo = mid + 1;
            else hi = mid - 1;
        }

        return false;
    }
}
