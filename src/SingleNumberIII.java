/**
 * 260. 只出现一次的数字 III
 * https://leetcode-cn.com/problems/single-number-iii/comments/
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 示例 :
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 *
 * 注意：
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }

        int bit = (xor & (xor - 1)) ^ xor;
        int num1 = 0, num2 = 0;
        for (int i : nums) {
            if ((bit & i) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }

        return new int[] {num1,num2};
    }
}
