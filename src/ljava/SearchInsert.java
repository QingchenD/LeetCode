package ljava;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int result;
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (lo + hi) / 2;
        while (lo < hi) {
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
            mid = (lo + hi) / 2;
        }

        if (nums[mid] > target) {
            result = mid;
        } else {
            result = mid + 1;
        }

        return result;
    }
}
