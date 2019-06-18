import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/132/
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 * 注意：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 *
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 */

public class MaxSlidingWindow {
    //超级慢
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int[] window = new int[k];

        for (int i = 0; i < nums.length - k + 1; i++) {
            System.arraycopy(nums, i, window, 0,k);
            Arrays.sort(window);
            res[i] = window[k - 1];
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        // save index of number,the maximum number is at head , min number is at tail.
        LinkedList<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // remove the header number if it is out of window .
            if(!deque.isEmpty() && deque.peekFirst() == i - k) deque.pollFirst();

            // remove the small number
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            deque.addLast(i);  // add the index of number to tail of list

            if((i + 1) >= k) res[i + 1 - k] = nums[deque.peekFirst()];  //head is the maximum number
        }
        return res;
    }
}
