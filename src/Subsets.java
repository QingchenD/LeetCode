import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/explore/interview/card/tencent/227/hui-su-suan-fa/944/
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */


public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        List<Integer> list;
        long count = (long)Math.pow(2.0, (double)(nums.length));
        long bitPhase;
        int bitShit;
        for (int i = 1; i < count; i++) {
            bitPhase = i;
            list = new ArrayList<>();
            bitShit = 0;
            while ((bitPhase >> bitShit) > 0) {
                if ((bitPhase >> bitShit & 1) == 1) {
                    list.add(nums[bitShit]);
                }
                bitShit++;
            }
            result.add(list);
        }

        // add empty list
        list = new ArrayList<>();
        result.add(list);

        return result;

    }
}
