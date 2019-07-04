/**
 * 400. 第N个数字
 * https://leetcode-cn.com/problems/nth-digit/
 *
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 *
 * 示例 1:
 * 输入:
 * 3
 * 输出:
 * 3
 *
 * 示例 2:
 * 输入:
 * 11
 * 输出:
 * 0
 *
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */

public class FindNthDigit {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了98.14%的用户
     * 内存消耗 :34.3 MB, 在所有 Java 提交中击败了64.83%的用户
     */
    public int findNthDigit(int n) {
        if (n < 10) return n;

        int[] count = new int[9];
        for (int i = 0; i < count.length; i++) {
            count[i] = 9 * (int)Math.pow(10, i);
        }

        int index = 0;
        int bits = 0;
        for (int i = 0; i < count.length; i++) {
            if (n - index > count[i] * (i + 1L)) {
                index += count[i] * (i + 1);
                bits = (i + 1);
            }
        }

        int num = (n - index) / (bits + 1);
        int mod = (n - index) % (bits + 1);
        num = mod == 0 ? num - 1 : num;   //mod为0，一个完成的数，num刚好可以加1； 为了表示前一个完整的数，num需要减掉1.
        mod = mod == 0 ? bits : mod - 1;  // mode为0， 表示最后一位数。mod不为0，表示从左到右的数，所以mode-1;

        //Math.pow()返回值是浮点数，如果超过9位数，会用科学计数法表示，如123456789 toString:1.23456789E8,
        //需强制转换为整数
        return String.valueOf((int)(num + Math.pow(10, bits))).charAt(mod) - '0';
    }

}
