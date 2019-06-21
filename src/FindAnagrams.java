import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) return list;

        int[] pattern = new int[26];
        for (char ch : p.toCharArray()) {
            pattern[ch - 'a']++;
        }

        int[] str = new int[26];
        for (int i = 0; i < s.length(); i++) {
            str[s.charAt(i) - 'a']++;
            if (i >= p.length()) {
                str[s.charAt(i - p.length()) - 'a']--;
            }

            if (i >= p.length() - 1) {
                int index = 0;
                while (index < pattern.length) {
                    if (pattern[index] == str[index]) index++;
                    else break;
                }
                if (index == pattern.length) list.add(i - (p.length() - 1));
            }
        }

        return list;
    }

    /**
     * 取出子串，排序，比较，速度太慢
     * o(n * length * n * loglength) -> O(n^2)
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) return list;

        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        String pattern = String.valueOf(pChars);

        for (int i = 0; i <= s.length() - pChars.length; i++) {
            char[] subStr = s.substring(i, i + pChars.length).toCharArray();
            Arrays.sort(subStr);
            if (pattern.equals(String.valueOf(subStr))) list.add(i);
        }

        return list;
    }
}
