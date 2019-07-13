package mykotlin

import java.util.ArrayList
import java.util.HashMap

/**
 * 756. 金字塔转换矩阵
 * https://leetcode-cn.com/interview/1/
 * https://leetcode-cn.com/problems/pyramid-transition-matrix/submissions/
 *
 * 现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示，例如 “Z”。
 * 使用三元组表示金字塔的堆砌规则如下：
 * (A, B, C) 表示，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。
 * 初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。
 * 如果可以由基层一直堆到塔尖返回true，否则返回false。
 *
 * 示例 1:
 * 输入: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
 * 输出: true
 * 解析:
 * 可以堆砌成这样的金字塔:
 *     A
 *    / \
 *   D   E
 *  / \ / \
 * X   Y   Z
 * 因为符合('X', 'Y', 'D'), ('Y', 'Z', 'E') 和 ('D', 'E', 'A') 三种规则。
 *
 */

class PyramidTransition {

    /**
     * 执行用时 :288 ms, 在所有 Kotlin 提交中击败了100.00%的用户
     * 内存消耗 :34.8 MB, 在所有 Kotlin 提交中击败了100.00%的用户
     */
    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        if (allowed.isEmpty()) return false

        val map = HashMap<String, ArrayList<Char>>()
        for (string in allowed) {
            val key = string.substring(0, 2)
            map.putIfAbsent(key, ArrayList())
            map[key]!!.add(string.last())
        }
        return dfs("", bottom, 0, map)
    }

    private fun dfs(upper: String, bottom: String, bottomIndex: Int, allow: Map<String, ArrayList<Char>>): Boolean {
        if (upper.length <= 1 && bottomIndex == (bottom.length - 1)) return true

        if (bottomIndex == bottom.length - 1) {
            return dfs("", upper, 0, allow)
        }

        val key = bottom.substring(bottomIndex, bottomIndex + 2)
        val list = allow[key]
        if (list != null) {
            for (ch in list) {
                if (dfs(upper + ch, bottom, bottomIndex + 1, allow )){
                    return true
                }
            }
        }

        return false
    }

//    fun pyramidTransition(bottom: String, allowed: List<String>?): Boolean {
//        if (allowed == null || allowed.isEmpty()) return false
//
//        val map = HashMap<String, ArrayList<Char>>()
//        for (str in allowed) {
//            val key = str.substring(0, 2)
//            map.putIfAbsent(key, ArrayList())
//            map[key]!!.add(str[2])
//        }
//        return dfs("", bottom, 0, map)
//    }
//
//    private fun dfs(upper: String, bottom: String, bottomIndex: Int, allow: Map<String, List<Char>>): Boolean {
//        if (upper.length <= 1 && bottomIndex == bottom.length - 1) return true
//
//        if (bottomIndex == bottom.length - 1) {
//            return dfs("", upper, 0, allow)
//        }
//
//        val key = bottom.substring(bottomIndex, bottomIndex + 2)
//        val list = allow[key]
//        if (list != null) {
//            for (ch in list) {
//                if (dfs(upper + ch, bottom, bottomIndex + 1, allow)) {
//                    return true
//                }
//            }
//        }
//        return false
//    }
}