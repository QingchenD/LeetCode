package ljava;

import java.util.*;

/**
 * 347. 前K个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 */

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer n = map.get(i);
            if (n == null) map.put(i, 1);
            else map.put(i, n + 1);
        }

        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>(){ //小顶堆，容量11
            @Override
            public int compare(Map.Entry i1,Map.Entry i2) {
                return (int)i1.getValue() - (int)i2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() >= k) {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.poll();
                    queue.add(entry);
                }
            } else queue.add(entry);
        }

        List<Integer> result = new ArrayList<>();
        while (queue.size() > 0) {
            result.add(queue.poll().getKey());
        }

        return result;

    }
}
