package ljava;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 *  https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 *
 *  输入: "abcabcbb"
 *  输出: 3
 *  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

public class SubstringMaxLongNodupicate {

    /**
     * 算法：
     *   f(n) = f(n-1) + 1
     * 如果当前（i）字符上次出现的位置 x, 如果 i-x大于f(n -1) + 1,
     * 则当前不重复字符长度 增加1， 否则变为 i - x，且记录最长不重复字串的藏独
     *
     * 执行用时 :9 ms, 在所有 Java 提交中击败了96.72%的用户
     * 内存消耗 :38 MB, 在所有 Java 提交中击败了90.19%的用户
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int curLength = 0;
        int maxLength = 0;
        int[] position = new int[128];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }

        for (int i = 0; i < s.length(); i ++) {
            int num = s.charAt(i);
            int preIndex = position[num];
            if (preIndex < 0 || i - preIndex > curLength) {
                curLength++;
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = i - preIndex;
            }
            position[num] = i;
        }

        return (curLength > maxLength) ? curLength : maxLength;
    }



    /**
     * 69ms 超过26.55的用户
     */
    /*
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLength = 1;
        int charStart = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (charMap.containsKey(ch) && charMap.get(ch) >= charStart) {
                // (i - 1） - charStart  + 1  = i - charStart
                if ( i  - charStart > maxLength) {
                    maxLength  = i - charStart;
                }
                charStart = charMap.get(ch) + 1;
            }
            charMap.put(ch,i);
        }

        // i + 1 - charStart = s.length - charStart
        maxLength = s.length() - charStart > maxLength ? s.length() - charStart : maxLength;

        return maxLength;
    }
     */
}
