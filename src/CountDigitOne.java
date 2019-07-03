/**
 * 233. 数字 1 的个数
 * https://leetcode-cn.com/problems/number-of-digit-one/comments/
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 示例:
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 */

public class CountDigitOne {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了50.00%的用户
     * 内存消耗 :33.6 MB, 在所有 Java 提交中击败了15.12%的用户
     */
    /*
    public int countDigitOne(int n) {
        if (n <= 0) return 0;

        return doCount(String.valueOf(n));
    }

    private int doCount(String s) {
        char[] numbs = s.toCharArray();
        if (numbs.length == 0) return 0;

        int first = numbs[0] - '0';
        if (numbs.length == 1 && first == 0) return 0;
        if (numbs.length == 1 && first > 0) return 1;

        int count = 0;
        if (first > 1) {
            count = powerBase10(numbs.length - 1);
        } else if (first == 1) {
            count = Integer.valueOf(String.valueOf(numbs,1, numbs.length - 1)) + 1;
        }

        int countOtherDigits = first * (numbs.length - 1) * powerBase10(numbs.length - 2);
        int countRecursive = doCount(s.substring(1));

        return count + countOtherDigits + countRecursive;
    }

    private int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; ++i) {
            result *= 10;
        }
        return result;
    }
     */


    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :32.8 MB, 在所有 Java 提交中击败了17.44%的用户
     */

    public int countDigitOne(int n) {
        int num = n,i = 1, s = 0;
        while (num > 0)  //分别计算个、十、百......千位上1出现的次数，再求和。
        {
            if (num % 10 == 0) {
                s += (num / 10) * i;
            } else if(num % 10 == 1) {
                s += (num / 10) * i + (n % i) + 1;
            } else {                         //(num % 10 > 1)
                s += (num / 10 + 1) * i;
            }

            num /= 10;
            i *= 10;
        }
        return s;
    }


}
