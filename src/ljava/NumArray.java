package ljava;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 *  示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 */


public class NumArray {

    private int[] sum;
    public NumArray(int[] nums) {
        this.sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (!(i < sum.length && j < sum.length && i <= j)) return -1;

        return i == 0 ? sum[j] : sum[j] - sum[i - 1];
    }
}
