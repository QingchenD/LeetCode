package ljava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]
 *
 */

public class SubarraySum {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * leedcode : 38ms
     * 利用hash表存储和统计累加和中数字出现的次数，速度提交近7倍。
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i : nums) {
            sum += i;

            Integer c = map.get(sum - k);
            count += c == null ? 0 : c;

            c = map.get(sum);
            map.put(sum, c == null ? 1 : c + 1);
        }

        return count;
    }


    /**
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(n)
     *
     * leedcode : 283ms
     * 利用已经计算好的数组和，减少重复计算，时间减少接近一半。
     */
    public int subarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) count++;
            }
        }

        return count;
    }

    /**
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(1)
     *
     * leetcode 测试：422ms
     */
    public int subarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }

        return count;
    }
}
