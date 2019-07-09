package mykotlin

class ConstructRectangle {
    /**
     * 执行用时 :260 ms, 在所有 Kotlin 提交中击败了100.00%的用户
     * 内存消耗 :32.3 MB, 在所有 Kotlin 提交中击败了100.00%的用户
     */
    fun constructRectangle(area: Int): IntArray {
        var width = Math.sqrt(area.toDouble()).toInt()
        while (area > 0 && area % width != 0) {
            width--
        }

        return intArrayOf(area / width, width)
    }
}
