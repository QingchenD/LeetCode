/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];
        for(int i = 1;i < nums.length; i++) {
            if(sum > 0) sum += nums[i];
            else sum = nums[i];
            if(result < sum) result = sum;
        }
        return result;
    }

    //分治方法
    private int solve(int[] nums, int lo, int hi) {

        if (lo == hi) return nums[lo];

        int mid = (lo + hi) >> 1;
        int lmax = solve(nums, lo, mid);
        int hmax = solve(nums, mid + 1, hi);

        //跨越分割点的和
        int sum = 0, lsum = nums[mid], hsum = 0;
        for (int i = mid; i >= lo ; i--) {
            sum += nums[i];
            if (sum > lsum) lsum = sum;
        }

        sum = 0;
        for (int i = mid + 1; i <= hi ; i++) {
            sum += nums[i];
            if (sum > hsum) hsum = sum;
        }
        sum = lsum + hsum;

        return Math.max(Math.max(lmax,hmax), sum);
    }

}
