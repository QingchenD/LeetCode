package ljava;

/**
 * https://leetcode-cn.com/explore/featured/card/recursion-i/258/memoization/1212/
 *
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，
 * 后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)
 */

public class Fib {

    /**
     * 利用数学公式求解：
     * an = (1 / sqrt(5)) * (((1 + sqrt(5)) / 2) ^ n) - ((1 - sqrt(5)) / 2) ^ n)
     */
    public int fib(int N) {
        if (N < 2) return N;

        return (int)((Math.pow((Math.sqrt(5) + 1) / 2L, N) - Math.pow((1 - Math.sqrt(5)) / 2L, N)) / Math.sqrt(5));
    }

    /**
     * 执行用时：0 ms 超过100%的用户
     */
    public int fib2(int N) {
        if (N < 2) return N;

        int[] result = new int[N + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= N; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[N];
    }


    /**
     * 执行用时：0 ms 超过100%的用户
     */
    public int fib1(int N) {
        if (N < 2) return N;

        int[] result = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            result[i] = -1;
        }
        result[0] = 0;
        result[1] = 1;

        return fibonacci(N, result);
    }

    private int fibonacci(int n, int[] result) {
        if (result[n] != -1) return result[n];
        else if (result[n] == -1) {
            result[n] = fibonacci(n - 1, result) + fibonacci(n - 2, result);
        }
        return result[n];
    }
}
