/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 */

public class LengthOfLIS {

    /**
     dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
     由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
     对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
     1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
     数组尾部, 并将最长递增序列长度maxL加1
     2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]

     时间复杂度:O(n*log(n))
     空间复杂度：O(n)

     leetcode时间：2ms
     速度提高约15倍
     **/
    public int lengthOfLIS(int[] nums) {
        int maxL = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo + ((hi - lo) >> 1);
                if(dp[mid] < num)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            dp[lo] = num;
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }

    /**
     * 用数据记录，前i个有序数字的长度：
     *  10, 9, 2, 5, 3, 7, 101, 18
     *  1   1  1  2  2  3  4    4
     *
     * 时间复杂度: o(n*n)
     * 空间复杂度: O(n)
     *
     * leetcode : 30ms
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLength = 0;
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            for (int j = 0 ; j < i; j++) {
                if (nums[j] < nums[i])
                    count[i] = Math.max(count[j] + 1, count[i]);
            }
            maxLength = Math.max(maxLength, count[i]);
        }

        return maxLength;
    }
}
