import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        addToList(nums, result);
        permute(nums, 0, nums.length - 1, result);
        return result;
    }

    private void permute(int[] nums , int low, int high, List<List<Integer>> result) {
        for (int i = low; i <= high; i++) {
            for (int j = i + 1; j <= high; j++) {
                swap(nums, i, j);
                addToList(nums, result);
                permute(nums, i + 1, high, result);
                swap(nums, i, j);
            }
        }
    }

    private void addToList(int[] nums , List<List<Integer>> result ) {
        List<Integer> list = new ArrayList<>();
        for ( Integer integer : nums) {
            list.add(integer);
        }
        result.add(list);
    }

    private void swap(int[] nums , int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
