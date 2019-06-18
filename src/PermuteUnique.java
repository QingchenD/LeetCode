import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        addToList(nums, result);

        permute(nums, 0, nums.length - 1, result);

        return result;
    }

    private void permute(int[] nums , int low, int high, List<List<Integer>> result) {
        for (int i = low; i <= high; i++) {
            for (int j = i + 1; j <= high; j++) {
                if (nums[i] == nums[j]) continue;
                if (i + 2 <= j && nums[j - 1] == nums[j]) continue;
                swap(nums, i, j);
                addToList(nums, result);
                permute(nums, i + 1, high, result);
                swap(nums, i, j);
            }
        }
    }

    void addToList(int[] nums , List<List<Integer>> result ) {
        List<Integer> list = new ArrayList<>();
        for ( Integer integer : nums) {
            list.add(integer);
        }
        result.add(list);
    }

    void swap(int[] nums , int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
