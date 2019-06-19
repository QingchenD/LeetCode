import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *  [2,2,2,2],
 *  [2,3,3],
 *  [3,5]
 * ]
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || target < 0) return null;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        subSum(candidates, 0, target, list, result);
        return result;
    }


    private void subSum(int[] candidates, int from, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> l = new ArrayList<>();
            l.addAll(list);
            result.add(l);

            // 该列表已经保存，删除最后一个
            list.remove(list.size() - 1);
            return;
        }

        for (int i = from; i < candidates.length; i++) {
            if (target >= candidates[from]) {
                list.add(candidates[i]);
                subSum(candidates, i, target - candidates[i], list, result);
            }
        }

        if (list.size() > 0) {
            list.remove(list.size() - 1);
        }
    }
}
