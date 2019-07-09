package ljava;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/236/learn-to-use-set/979/
 *
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 * 输入: 19
 * 输出: true
 *
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 2 + 02 + 02 = 1
 *
 */

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int sum = 0;
        while (true) {
            while (n > 0) {
                sum += (int) Math.pow(n % 10, 2);
                n /= 10;
            }

            if (sum == 1) return true;
            else if (!set.add(sum)) return false;
            else  { n = sum; sum = 0;  }
        }
    }
}
