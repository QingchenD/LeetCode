package ljava;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/130/
 *

 *
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 */

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0, t = 0;
        int count = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            count++;
            if (slow == fast) { System.out.println(count);   break;}
        }
        while (true) {
            slow = nums[slow];
            t = nums[t];
            if (slow == t) break;
        }
        return slow;
    }
}
