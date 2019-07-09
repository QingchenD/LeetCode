package ljava;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *  
 * 注意事项：您可以假定该字符串只包含小写字母
 *
 */


public class FirstUniqChar {

    /**
     * 执行用时 :9 ms, 在所有 Java 提交中击败了95.30%的用户
     * 内存消耗 :37.5 MB, 在所有 Java 提交中击败了94.29%的用户
     *
     * 数组大小改成128， 会再稍微快一点。
     */
    public int firstUniqChar(String s) {
        if (s == null) return -1;

        char[] str = s.toCharArray();
        int[] chars = new int[128];
        for (int i = 0; i < str.length; i++) {
            chars[str[i]] += 1;
        }

        for (int i = 0; i < str.length; i++) {
            if (chars[str[i]] == 1) return i;
        }

        return -1;
    }




    /**
     * 执行用时 :13 ms, 在所有 Java 提交中击败了89.70%的用户
     * 内存消耗 :48.6 MB, 在所有 Java 提交中击败了34.83%的用户
     *
     * 不使用String.charAt（）函数，可以减少约一半的时间。
     */
    public int firstUniqChar2(String s) {
        if (s == null) return -1;

        char[] str = s.toCharArray();
        int[] chars = new int[26];
        for (int i = 0; i < str.length; i++) {
            chars[str[i] - 'a'] += 1;
        }

        for (int i = 0; i < str.length; i++) {
            if (chars[str[i] - 'a'] == 1) return i;
        }

        return -1;
    }


    /**
     * 执行用时 :24 ms, 在所有 Java 提交中击败了66.51%的用户
     * 内存消耗 :48.4 MB, 在所有 Java 提交中击败了36.18%的用户
     */
    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) return -1;

        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }
}
