/**
 * 缺失数字
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/274/math/1193/
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 */

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int length = nums.length;
        int qiwang = ((length + 1) * length) >> 1;

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        return qiwang - sum;

    }
}
