package mykotlin

/**
 * 453. 最小移动次数使数组元素相等
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 *
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
 *
 * 示例:
 * 输入:
 * [1,2,3]
 * 输出:
 * 3
 *
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 */

class MinMoves {
    /**
     * 执行用时 :560 ms, 在所有 Kotlin 提交中击败了100.00%的用户
     * 内存消耗 :58.7 MB, 在所有 Kotlin 提交中击败了100.00%的用户
     */
    fun minMoves(nums: IntArray): Int {
        if (nums.size < 2) return 0;

        var min = nums[0]
        for (num in nums) {
            min = Math.min(num, min)
        }

        var rst = 0
        for (num in nums) {
            rst += num - min
        }

        return rst
    }
}

