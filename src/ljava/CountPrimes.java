package ljava;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/25/math/61/\
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 */

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);

        int halfLength = n >> 1;
        for(int i = 2; i <= halfLength; i++){
            if(prime[i]){
                // 将i的2倍、3倍、4倍...都标记为非素数
                for(int j = i * 2; j < n; j += i){
                    if (prime[j]) prime[j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++){
            if (prime[i]) count++;
        }

        return count;
    }


    public int countPrimes2(int n) {
        int result = 0;
        boolean isPrime;
        for (int i = 2; i < n; i++) {
            isPrime = true;
            for (int j = (i >> 1); j >= 2; j--) {
                if (i % j == 0) { isPrime = false; break;}
            }

            if (isPrime) result++;
        }

        return result;
    }
}
