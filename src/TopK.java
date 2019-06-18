import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *  https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1018/
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 */

public class TopK {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k) // 维护堆的大小为 K
                pq.poll();
        }
        return pq.peek();
    }

    public int findKthLargest2(int[] nums, int k) {

        if (k < 1 || nums == null || k > nums.length ) return 0;

        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
