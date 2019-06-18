/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/233/sliding-window/971/
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 */

public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int lo = 0;
        int hi = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = nums[0];
        while (true) {
            if (sum >= s) {
                minLen = Math.min(minLen,hi - lo + 1);
                sum -= nums[lo++];
            } else if (hi + 1 < nums.length) sum += nums[++hi];
            else break;
        }

        return (minLen == Integer.MAX_VALUE)? 0 : minLen;
    }
}
