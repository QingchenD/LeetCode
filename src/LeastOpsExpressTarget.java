import com.sun.javafx.binding.StringFormatter;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/least-operators-to-express-number/
 * 给定一个正整数 x，我们将会写出一个形如 x (op1) x (op2) x (op3) x ... 的表达式，其中每个运算符 op1，op2，… 可以是加、减、乘、除（+，-，*，或是 /）之一。例如，对于 x = 3，我们可以写出表达式 3 * 3 / 3 + 3 - 3，该式的值为 3 。
 * 在写这样的表达式时，我们需要遵守下面的惯例：
 * 除运算符（/）返回有理数。
 * 任何地方都没有括号。
 * 我们使用通常的操作顺序：乘法和除法发生在加法和减法之前。
 * 不允许使用一元否定运算符（-）。例如，“x - x” 是一个有效的表达式，因为它只使用减法，但是 “-x + x” 不是，因为它使用了否定运算符。
 * 我们希望编写一个能使表达式等于给定的目标值 target 且运算符最少的表达式。返回所用运算符的最少数量。
 *
 * 示例 1：
 * 输入：x = 3, target = 19
 * 输出：5
 * 解释：3 * 3 + 3 * 3 + 3 / 3 。表达式包含 5 个运算符。
 *
 * 示例 2：
 * 输入：x = 5, target = 501
 * 输出：8
 * 解释：5 * 5 * 5 * 5 - 5 * 5 * 5 + 5 / 5 。表达式包含 8 个运算符。
 *
 */

public class LeastOpsExpressTarget {

    /**
     * 算法思路：
     *   如果 k1 = x^n; k2 = x^(n+1), 且 k1 < y < k2
     *   则  有两种表示方式：
     * pos the number of operations needed to get y % (x ^ (k+1))
     * neg the number of operations needed to get x ^ (k + 1) - y % (x ^ (k + 1))
     *
     *
     * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :34 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int leastOpsExpressTarget(int x, int y) {
        int pos = 0, neg = 0, k = 0, pos2, neg2, cur;
        while (y > 0) {
            cur = y % x;
            y /= x;
            if (k > 0) {
                pos2 = Math.min(cur * k + pos, (cur + 1) * k + neg);
                neg2 = Math.min((x - cur) * k + pos, (x - cur - 1) * k + neg);
                pos = pos2;
                neg = neg2;
            } else {
                pos = cur * 2;
                neg = (x - cur) * 2;
            }
            k++;
        }
        return Math.min(pos, k + neg) - 1;
    }


    /**
     * 执行用时 :12 ms, 在所有 Java 提交中击败了50.00%的用户
     * 内存消耗 :35.6 MB, 在所有 Java 提交中击败了80.00%的用户
     */

    /*
    private Map<String, Integer> memo;
    private int x;
    public int leastOpsExpressTarget(int x, int target) {
        memo = new HashMap<>();
        this.x = x;
        return dp(0, target) - 1;
    }

    private int dp(int i, int target) {
        String code = "" + i + "#" + target;
        if (memo.containsKey(code))
            return memo.get(code);

        int ans;
        if (target == 0) {
            ans = 0;
        } else if (target == 1) {
            ans = cost(i);
        } else if (i >= 39) {
            ans = target + 1;
        } else {
            int t = target / x;
            int r = target % x;
            ans = Math.min(r * cost(i) + dp(i+1, t),
                    (x-r) * cost(i) + dp(i+1, t+1));
        }

        memo.put(code, ans);
        return ans;
    }

    private int cost(int x) {
        return x > 0 ? x : 2;
    }
    */
}
