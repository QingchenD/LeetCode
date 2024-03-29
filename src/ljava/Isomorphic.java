package ljava;

/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/237/learn-to-use-dict/987/
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 */


public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sCount = new int[128];
        int[] tCount = new int[128];

        for (int i = 0; i < s.length(); i++) {
            //上一次出现的位置不同， 返回false
            if (sCount[s.charAt(i)] != tCount[t.charAt(i)]) return false;
            sCount[s.charAt(i)] = i + 1;
            tCount[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
