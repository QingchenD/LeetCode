package ljava;

/**
 * 494. 目标和
 * https://leetcode-cn.com/problems/target-sum/
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 *
 * 注意:
 * 数组的长度不会超过20，并且数组中的值全为正数。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果为32位整数。
 *
 */

public class FindTargetSumWays {

    /*
     * sum(P) 前面符号为+的集合；sum(N) 前面符号为减号的集合
     * 所以题目可以转化为
     * sum(P) - sum(N) = target
     * => sum(nums) + sum(P) - sum(N) = target + sum(nums)
     * => 2 * sum(P) = target + sum(nums)
     * => sum(P) = (target + sum(nums)) / 2
            * 因此题目转化为01背包，也就是能组合成容量为sum(P)的方式有多少种
     */
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int w = (sum + S) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[w];
    }


    /**
     * 利用传值，保存了中间结果，但是速度依然很慢。
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays1(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;

        int sum = 0;
        int[] count = new int[1];
        subSum(nums, S, sum, 0, count);

        return count[0];
    }

    private void subSum(int[] numbs, int target, int sum, int index, int[] count) {
        if (index > numbs.length - 1) return;

        if (index == numbs.length - 1) {
            if (sum + numbs[index] == target) count[0]++;
            if (sum - numbs[index] == target) count[0]++;
            return;
        }

        subSum(numbs, target, sum + numbs[index], index + 1, count);
        subSum(numbs, target, sum - numbs[index], index + 1, count);
    }


    /**
     * 太费时间
     * 时间复杂度 o(n* pow(2,n))
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays12(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;

        int rst = 0;
        int sum = 0;
        int count = (int)Math.pow(2, nums.length);
        for (int i = 0 ; i < count; i++) {
            sum = 0;
            for (int j = 0; j < nums.length; j++) {
                int flag = (i >> j) & 1;
                sum += flag == 0 ? -nums[j] : nums[j];
            }
            if (sum == S) rst++;
        }

        return rst;
    }


}
