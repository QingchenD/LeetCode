package mykotlin

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */

class NumArray(nums: IntArray) {
    private val sum: IntArray
    init {
        this.sum = IntArray(nums.size)
        for (i in nums.indices) {
            if (i == 0) {
                sum[i] = nums[i]
            } else {
                sum[i] = sum[i - 1] + nums[i]
            }
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        if (!(i < sum.size && j < sum.size && i <= j)) return -1

        return if (i == 0) sum[j] else sum[j] - sum[i - 1]
    }
}
