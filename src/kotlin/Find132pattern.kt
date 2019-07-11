package mykotlin

/**
 * 456. 132模式
 * https://leetcode-cn.com/problems/132-pattern/
 *
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：
 * 当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，
 * 验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 * 输入: [1, 2, 3, 4]
 * 输出: False
 * 解释: 序列中不存在132模式的子序列。
 *
 * 示例 2:
 * 输入: [3, 1, 4, 2]
 * 输出: True
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 *
 * 示例 3:
 * 输入: [-1, 3, 2, 0]
 * 输出: True
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 */

class Find132pattern {

    /**
     * 算法：
     *  1. 利用Stack 记录3的值
     *  2. 利用变量second记录2的值。
     *  3. 倒序遍历数组，当前值为1值， 如果当前值小于second，则return true。
     *
     * 执行用时 :432 ms, 在所有 Kotlin 提交中击败了100.00%的用户
     * 内存消耗 :45.1 MB, 在所有 Kotlin 提交中击败了100.00%的用户
     */
    fun find132pattern(nums: IntArray): Boolean {
        if (nums.size < 3) return false

        var top = -1
        val stack = IntArray(nums.size) // 记录132的3
        var second = Integer.MIN_VALUE // 记录132的2
        for (i in nums.size - 1 downTo 0) { // num[i] 当前132的1
            if (nums[i] < second) {
                return true
            }
            while (top != -1 && stack[top] < nums[i]) {  //如果当前值大于3值，则取出值，赋值给2.
                second = stack[top--]
            }
            stack[++top] = nums[i]                    //当前值，赋值给3
        }
        return false
    }
}