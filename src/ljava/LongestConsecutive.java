package ljava;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1019/
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            int sum = left + right + 1;
            map.put(num, sum);
            res = Math.max(res, sum);
            map.put(num - left, sum);
            map.put(num + right, sum);
        }
        return res;
    }
}
