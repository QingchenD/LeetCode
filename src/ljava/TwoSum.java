package ljava;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/238/lookup-table-related-sum-questions/991/
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] backupNums = new int[nums.length];
        int[] result = new int[]{-1, -1};
        System.arraycopy(nums,0, backupNums, 0, nums.length);
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length - 1;
        int sum;
        int result0 = 0, result1 = 0;
        while (lo < hi) {
            sum = nums[lo] + nums[hi];
            if (sum == target) {
                result0 = nums[lo];
                result1 = nums[hi];
                break;
            } else if (sum < target) lo++;
            else hi--;
        }

        for (int i = 0; i < backupNums.length; i++) {
            if (result[0] != -1 && result[1] != -1) break;
            else if (backupNums[i] == result0 && result[0] == -1) {
                result[0] = i;
            } else if (backupNums[i] == result1 && result[1] == -1) {
                result[1] = i;
            }
        }

        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0 ; i < nums.length; i++) {
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == tmp) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
