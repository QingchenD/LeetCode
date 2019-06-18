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


    /** 递归实现 速度 很慢 会超时 **/
    private int subSquares(int n, int maxSqrt, int step, int minLength) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (step > 4 || step > minLength) return step;
        int length = n;

        while (Math.pow(maxSqrt,2) > n) {
            maxSqrt--;
        }

        for (int i = maxSqrt ; i >= 1; i--) {
            length = Math.min(length, 1 + subSquares((int)(n - Math.pow(maxSqrt, 2)), i,step + 1, length));
        }

        return length;
    }
}
