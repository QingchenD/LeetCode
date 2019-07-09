package mykotlin

import java.util.*


class FindRadius {
    /**
     * 执行用时 :584 ms, 在所有 Kotlin 提交中击败了100.00%的用户
     * 内存消耗 :58.8 MB, 在所有 Kotlin 提交中击败了100.00%的用户
     */
    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        var radius = 0
        Arrays.sort(heaters)
        for (house in houses) {
            var minDistance = Integer.MAX_VALUE
            var lo = 0
            var hi = heaters.size - 1
            while (lo < hi) {
                val mid = lo + hi shr 1
                if (house == heaters[mid]) {
                    minDistance = 0
                    break
                } else if (house > heaters[mid]) {
                    lo = mid + 1
                } else {
                    hi = mid - 1
                }
            }
            if (minDistance != 0) {
                minDistance = Math.min(Math.abs(heaters[lo] - house), minDistance)
                if (lo - 1 >= 0) {
                    minDistance = Math.min(Math.abs(heaters[lo - 1] - house), minDistance)
                }
                if (lo + 1 <= heaters.size - 1) {
                    minDistance = Math.min(Math.abs(heaters[lo + 1] - house), minDistance)
                }
            }

            radius = Math.max(radius, minDistance)
        }
        return radius
    }
}
