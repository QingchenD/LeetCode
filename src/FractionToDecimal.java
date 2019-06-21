import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 *
 * 示例 2:
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 *
 * 示例 3:
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 *
 */

public class FractionToDecimal {
    /**
     *  各种边界值是需要考虑的：
     *  1. 负数
     *  2. 负数最大值，负数最小值
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return null;
        if (numerator == 0) return "0";

        int flag = 1;
        if (numerator < 0) flag *= -1;
        if (denominator < 0) flag *= -1;
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        StringBuilder s = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        //计算整数部分
        long n = num / den;
        boolean bXiaoshu = false;

        //计算小数部分
        int index = 0;
        num %= den;
        while (num != 0) {
            bXiaoshu = true;
            if (map.containsKey(num)) break;

            map.put(num, index);
            index++;
            num *= 10;
            if (num < den) {
                s.append(0);
            } else {
                long c = num / den;
                s.append(c);
                num %= den;
            }
        }

        StringBuilder rst = new StringBuilder();
        Integer start = map.get(num);
        if (flag < 0) {
            rst.append("-");
        }
        rst.append(n);
        if (bXiaoshu) {
            rst.append(".");
            if (start != null) {
                rst.append(s.substring(0, start));
                rst.append("(");
                rst.append(s.substring(start));
                rst.append(")");
            } else {
                rst.append(s);
            }
        }

        return rst.toString();
    }
}
