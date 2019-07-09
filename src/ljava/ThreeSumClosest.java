package ljava;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int lo;
        int hi;
        int result = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2 ; i++) {
            lo = i + 1;
            hi = nums.length - 1;
            while (lo < hi) {
                int tmpDiff = nums[lo] + nums[hi] + nums[i] - target;
                if (Math.abs(tmpDiff) < Math.abs(diff)) {
                    diff = Math.abs(tmpDiff);
                    result = nums[lo] + nums[hi] + nums[i];
                }
                if (tmpDiff < 0) lo++;
                else hi--;
            }
        }

        return result;
    }
}
