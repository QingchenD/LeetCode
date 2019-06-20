/**
 * 581. 最短无序连续子数组
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 *
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 说明 :
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */

public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int lo = 0;
        int hi = nums.length - 1;
        //左边递增终止位置
        while (lo < nums.length - 1) {
            if (nums[lo] <= nums[lo + 1]) lo++;
            else break;
        }
        if (lo == nums.length - 1) return 0;

        //右边递减开始位置
        while (hi > 0) {
            if (nums[hi] >= nums[hi - 1]) hi--;
            else break;
        }

        //查找中间位置 最大和最小值
        int max = nums[lo];
        int min = nums[hi];
        for (int i = lo; i < hi; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        //左边 比 中间最小值 还小的第一个位置。
        int left = lo;
        while (left >= 0) {
            if (nums[left] > min) left--;
            else break;
        }

        //右边 比 中间最大值 还大的第一个位置
        int right = hi;
        while (right < nums.length) {
            if (nums[right] < max) right++;
            else break;
        }

        return right - left - 1;
    }
}
