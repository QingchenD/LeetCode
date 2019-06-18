import java.util.HashMap;

/**   https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
  *    输入: "abcabcbb"
  *    输出: 3
  *    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
  */

public class SubstringMaxLongNodupicate {

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
}
