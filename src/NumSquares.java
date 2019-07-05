import java.util.*;

/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/874/
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */

public class NumSquares {

//    public int numSquares(int n) {
//        int sqrt = (int)Math.sqrt(n);
//        int minCount = 4;
//        for (int i = sqrt; i >= 1; i++) {
//            if (sqrt * sqrt * 4 < n) break;
//            int num = n;
//            for (int j = i; j >= 1; j++) {
//                if ()
//            }
//        }
//    }



    /**
     * 84ms 超过21.75%的用户
     */
    /*
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int step = 0;
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (!set.add(curr)) {
                    continue;
                }
                for (int j = 1; j <= Math.sqrt(curr); j++) {
                    int next = curr - j * j;
                    if (next == 0) {
                        return step;
                    }
                    queue.offer(next);
                }
            }
        }
        return 0;
    }
    */


    /**
     * 算法：
     *    四平方定理：一个正整数，可以表示为四个平方数的和。
     *
     *  本代码只是简单的利用利用了边界4来做剪枝。
     *  优点：易于理解。
     *  缺点：代码没有达到最高效。
     *
     *  更高效的实现是利用四平方定理的性质去实现算法。
     *  优点：高效
     *  缺点：需要很熟悉定理性质，才能理解代码。
     *
     * 执行用时 :10 ms, 在所有 Java 提交中击败了93.90%的用户
     * 内存消耗 :33.9 MB, 在所有 Java 提交中击败了87.01%的用户
     *
     */
    public int numSquares(int n) {
        return  subSquares(n, (int)Math.sqrt(n), 0);
    }

    private int subSquares(int n, int maxSqrt, int step) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (maxSqrt * maxSqrt * (4 - step) < n) return 4;
        if (step > 4) return step;

        while (maxSqrt * maxSqrt > n) {
            maxSqrt--;
        }

        int length = n;
        for (int i = maxSqrt ; i >= 1; i--) {
            if (i * i * (4 - step) < n) break;
            length = Math.min(length, 1 + subSquares(n - (i * i), i,step + 1));
        }

        return length;
    }

}
