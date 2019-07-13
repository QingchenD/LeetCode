package ljava;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.*;

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
public class PyramidTransition {

    /**
     * 改进算法：
     *    1. 使用Hashmap存储allow数据，减少查询次数。算法速度提高一倍。
     *    2. 使用bottom(0,2)当做key，从Map中查找后继的Char， 速度又可提高一倍。
     *
     * 执行用时 :8 ms, 在所有 Java 提交中击败了93.33%的用户
     * 内存消耗 :35.9 MB, 在所有 Java 提交中击败了83.33%的用户
     */
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (allowed == null || allowed.size() == 0) return false;

        Map<String, List<Character>> map = new HashMap<>();
        for (String str : allowed) {
            String key = str.substring(0,2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str.charAt(2));
        }
        return dfs("", bottom, 0, map);
    }

    private boolean dfs(String upper ,String bottom, int bottomIndex, Map<String, List<Character>> allow) {
        if (upper.length() <= 1 && bottomIndex == (bottom.length() - 1)) return true;

        if (bottomIndex == bottom.length() - 1) {
            return dfs("", upper, 0, allow);
        } else {
            String key = bottom.substring(bottomIndex, bottomIndex + 2);
            List<Character> list = allow.get(key);
            if (list != null) {
                for (Character ch : list) {
                    if (dfs(upper + ch, bottom, bottomIndex + 1, allow)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * 执行用时 :40 ms, 在所有 Java 提交中击败了15.00%的用户
     * 内存消耗 :48.8 MB, 在所有 Java 提交中击败了5.55%的用户
     */
    public boolean pyramidTransition1(String bottom, List<String> allowed) {
        if (allowed == null || allowed.size() == 0) return false;

        return dfs(new StringBuilder(), bottom, allowed);
    }

    private boolean dfs(StringBuilder upper ,String bottom, List<String> allow) {
        if (upper.length() <= 1 && bottom.length() <= 1) return true;

        if (bottom.length() <= 1) {
            return dfs(new StringBuilder(), upper.toString(), allow);
        }
        else {
            for (String str : allow) {
                if (bottom.startsWith(str.substring(0, 2))) {
                    StringBuilder builder = new StringBuilder(upper.toString());
                    builder.append(str.charAt(str.length() - 1));
                    if (dfs(builder, bottom.substring(1), allow)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
