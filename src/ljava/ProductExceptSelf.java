package ljava;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/907/
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        //计算前面所有数字的乘积
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) result[i] = 1;
            else result[i] = result[i - 1] * nums[i - 1];
        }

        //计算前面所有数字的乘积
        int temp = 1;
        int swap;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                temp = nums[i];
                nums[i] = 1;
            } else {
                swap = nums[i];
                nums[i] = nums[i + 1] * temp;
                temp = swap;
            }
        }

        //计算除该数字外所有数字的乘积
        for (int i = 0; i < result.length; i++) {
            result[i] *= nums[i];
        }

        return result;
    }
}
