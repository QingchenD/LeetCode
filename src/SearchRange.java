/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */


public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;

        int lo = 0;
        int hi = nums.length - 1;
        int mid = lo + ((hi - lo) >> 1);
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) break;
            else if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }

        if (nums[mid] == target) {
            for (int i = 0, change = 0;; i++, change = 0) {
                if (mid - i >= 0 && nums[mid - i] == target) {
                    res[0] = mid - i;
                    change = 1;
                }
                if (mid + i < nums.length && nums[mid + i] == target) {
                    res[1] = mid + i;
                    change = 1;
                }

                if (change != 1) break;
            }
        }

        return res;
    }
}
