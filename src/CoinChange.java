import com.sun.org.glassfish.external.amx.AMX;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 *  示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的
 *
 */

public class CoinChange {

    public int coinChange1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }

        int N = arr.length;
        //dp[i][j]-->任意使用arr[i...N]的货币组成j的最少张数
        int[][] dp = new int[N + 1][aim + 1];
        // 设置最后一排的值，除了dp[N][0]为0之外，其他都是-1
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }

        //对于每张货币都有两个选择
        //选择这个货币：dp[i][j] = dp[i][j-arr[i]]+1
        //不选择：dp[i][j] = dp[i+1][j]
        //dp[i][j] = min(dp[i+1][j],dp[i][j-arr[i]+1)
        for (int i = N - 1; i >= 0; i--) { // 从底往上计算每一行
            for (int rest = 0; rest <= aim; rest++) { // 每一行都从左往右
                dp[i][rest] = -1; // 初始时先设置dp[i][rest]的值无效
                if (dp[i + 1][rest] != -1) { // 下面的值如果有效
                    dp[i][rest] = dp[i + 1][rest]; // dp[i][rest]的值先设置成下面的值
                }
                // 左边的位置不越界并且有效
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    if (dp[i][rest] == -1) { // 如果之前下面的值无效
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else { // 说明下面和左边的值都有效，取最小的
                        dp[i][rest] = Math.min(dp[i][rest],
                                dp[i][rest - arr[i]] + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }


    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;

        Arrays.sort(coins);
        int[] eachMinCoins = new int[amount + 1];
        for (int i = 1; i < eachMinCoins.length; i++) { // eachMinCoins[0] = 0
            eachMinCoins[i] = Integer.MAX_VALUE;
        }

        for (int i = coins[0]; i <= amount; i++) {
            for(int coin : coins) {
                if (i - coin < 0) break;

                eachMinCoins[i] = (int)Math.min(eachMinCoins[i], eachMinCoins[i - coin] + 1L);
            }
        }

        return eachMinCoins[amount] == Integer.MAX_VALUE ? -1 : eachMinCoins[amount];
    }

}
