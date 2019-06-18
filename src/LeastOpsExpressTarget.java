import com.sun.javafx.binding.StringFormatter;

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
    public int leastOpsExpressTarget(int x, int target) {
        if (x == 1) return target - 1;

        StringBuilder strBuilder = new StringBuilder();
        int product;
        while (true) {
            if (target > x) {
                product = 1;
                for (int i = 1; i < 32; i++) {
                    product *= x;
                    if (product > target) {
                        if (Math.abs(target - product / x) > Math.abs(target - product)){
                            strBuilder.append("*");
                            strBuilder.append(x);
                            strBuilder.append("-");
                            target = Math.abs(product - target);
                        } else {
                            target = Math.abs( target - product / x);
                            strBuilder.append("+");
                        }
                        break;
                    } else {
                        //if (strBuilder.length() > 0 && i == 1) strBuilder.append("+");
                        if (i > 1) strBuilder.append("*");
                        strBuilder.append(x);
                    }
                }
            } else if (target == x) {
                if (strBuilder.length() > 0) {
                    strBuilder.append("+");
                }
                strBuilder.append(x);
                break;
            }else if (target > 0) {
//                if (strBuilder.length() > 0) {
//                    strBuilder.append("+");
//                }
                strBuilder.append(x);
                strBuilder.append("/");
                strBuilder.append(x);
                target -= 1;
            } else break;
        }

        System.out.println(strBuilder.toString());
        return strBuilder.length() / 2 ;
    }
}
