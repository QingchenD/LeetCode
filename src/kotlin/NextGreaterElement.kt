package mykotlin

import java.util.HashMap

class NextGreaterElement {

    /**
     * 执行用时 :344 ms, 在所有 Kotlin 提交中击败了83.33%的用户
     * 内存消耗 :35.3 MB, 在所有 Kotlin 提交中击败了50.00%的用户
     */
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val hashMap = HashMap<Int, Int>()
        for (i in 0 until nums2.size - 1) {
            for (j in i + 1 until nums2.size) {
                if (nums2[j] > nums2[i]) {
                    hashMap.put(nums2[i], nums2[j])
                    break
                }
            }
        }
        val rst = IntArray(nums1.size)
        for (i in nums1.indices) {
            rst[i] = hashMap.getOrDefault(nums1[i], -1)
        }
        return rst
    }
}