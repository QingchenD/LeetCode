/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1017/
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */

public class TritSearch {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo)>>1) ;
            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    public int searchBackup(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (lo + hi) / 2 + (lo + hi) % 2;

        while (lo <= hi) {
            if (nums[mid] == target) return mid;
            if (lo == hi) return -1;

            if (target < nums[mid]) {
                if (nums[lo] < nums[mid] && target < nums[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if ((nums[mid] < nums[hi] &&  target <= nums[hi]) ||
                        nums[mid] > nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            mid = (lo + hi) / 2 + (lo + hi) % 2;
        }

        return -1;
    }
}
