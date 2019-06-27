import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了68.62%的用户
     * 内存消耗 :43.6 MB, 在所有 Java 提交中击败了65.71%的用户
     *
     * 算法：
     *    关键是：回溯和剪枝的方法， 需要仔细斟酌思考回味。
     *
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permute(nums, result, new LinkedList<>(), used);
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, LinkedList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            List<Integer> l = new ArrayList<>(list);
            result.add(l);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //剪枝的关键
            if (used[i] || (i > 0 && !used[i - 1] && nums[i - 1] == nums[i])) continue;

            list.add(nums[i]);
            used[i] = true;
            permute(nums, result, list, used);

            //回溯的关键
            used[i] = false;
            list.removeLast();
        }
    }
}
