package ljava;

import java.util.*;

/**
 * 1088. 易混淆数 II
 * https://leetcode-cn.com/contest/biweekly-contest-2/problems/confusing-number-ii/
 *
 * 本题我们会将数字旋转 180° 来生成一个新的数字。
 * 比如 0、1、6、8、9 旋转 180° 以后，我们得到的新数字分别为 0、1、9、8、6。
 * 2、3、4、5、7 旋转 180° 后，是 无法 得到任何数字的。
 * 易混淆数（Confusing Number）指的是一个数字在整体旋转 180° 以后，能够得到一个和原来 不同 的数，且新数字的每一位都应该是有效的。（请注意，旋转后得到的新数字可能大于原数字）
 * 给出正整数 N，请你返回 1 到 N 之间易混淆数字的数量。
 *
 * 示例 1：
 * 输入：20
 * 输出：6
 * 解释：
 * 易混淆数为 [6,9,10,16,18,19]。
 * 6 转换为 9
 * 9 转换为 6
 * 10 转换为 01 也就是 1
 * 16 转换为 91
 * 18 转换为 81
 * 19 转换为 61
 *
 * 示例 2：
 * 输入：100
 * 输出：19
 * 解释：
 * 易混淆数为 [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100]。
 *
 * 提示：
 * 1 <= N <= 10^9
 *
 */

public class ConfusingNumberII {

    /**
     * 采用深度遍历的方式
     * 1. 不使用set或者list保存结果。 可以节省3，4倍时间
     * 2. 反转不借助数组， 直接自己算，可以节省一倍时间。
     * 总共时间提高近10倍。
     *
     * 技巧：
     *   如果Num为0，不再加0,原来做法会继续用0加，导致生成的数字，不是升序的，
     *   会出现重复的数字，所以用来了set来存储结果。
     *
     * leetcode: 228ms
     */
    private int count = 0;
    public int confusingNumberII(int N) {
        if (N < 6) return 0;
        count = 0;
        dfs(0, N);
        return count;//set.size();
    }

    private void dfs (long num, int maxNum) {
        if (num <= maxNum) {
            if (rotate(num) != num) {
                count++;
            }

            if (num > 0) dfs(num * 10, maxNum);
            dfs(num * 10 + 1, maxNum);
            dfs(num * 10 + 6, maxNum);
            dfs(num * 10 + 8, maxNum);
            dfs(num * 10 + 9, maxNum);
        }
    }

    private long rotate(long num) {
        long y = 0;
        for (; num > 0; num /= 10) {
            int k = (int)num % 10;
            switch (k) {
                case 6: k = 9; break;
                case 9: k = 6; break;
            }
            y = y * 10 + k;
        }
        return y;
    }

    /**
     * 算法时间复杂度0(n);
     *
     * 超时
     */
    public int confusingNumberII_1(int N) {
        if (N < 6) return 0;

        List<Integer> list = new ArrayList<>();

        int count = 0;
        Map<Integer, Integer> confusePairs = new HashMap<>();
        confusePairs.put(0, 0);
        confusePairs.put(1, 1);
        confusePairs.put(6, 9);
        confusePairs.put(8, 8);
        confusePairs.put(9, 6);

        for (int i = 6; i <= N; i++) {
            int n = i;
            boolean suspected = true;
            while (n != 0) {
                int digital = n % 10;
                if (confusePairs.get(digital) == null) {
                    suspected = false;
                    break;
                }
                n /= 10;
            }

            if (suspected) {
                char[] reverse = new StringBuilder().append(i).reverse().toString().toCharArray();
                for (int index = 0; index < reverse.length; index++) {
                    reverse[index] = (char)(confusePairs.get(reverse[index] - '0') + '0');
                }
                if (Integer.valueOf(new String(reverse)) != i){
                    count++;
                    list.add(i);
                }
            }
        }

//        for (int i : list) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        return count;
    }
}
