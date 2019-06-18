/**
 *  https://leetcode-cn.com/problems/climbing-stairs/
 *
 *  假设你正在爬楼梯，需要n阶你才能到达楼顶。
 *  每次你可以爬1或者2个台阶。你有多少种 不同的方法爬到楼顶呢？
 *
 *  注意：给定n是一个正整数
 *
 *  输入： 2
 *  输出： 2
 *  解释： 有两种方法可以爬到楼顶。
 *  1.  1 阶 + 1 阶
 *  2.  2 阶
 */


public class ClimbStairs {

     /*
        f(n) = f(n-1) + f(n-2);
        n = 1;     (1)    f(1) = 1;
        n = 2;    (1+1,2) f(2) = 2;
     */
    public int climbStairs(int n) {
        int fn1 = 1;
        int fn2 = 2;
        int swap;
        if (n == 1) return 1;
        if (n == 2) return 2;

        while ((n-- > 2)) {
            swap = fn2;
            fn2 = fn2 + fn1;
            fn1 = swap;
        }

        return fn2;
    }
}
