/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/133/
 *
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 *
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 */

public class MinWindow {
    public String minWindow(String s, String t) {
        int[] tCharCount = new int[128]; // 记录目标字符串每个字母出现次数
        for (int i = 0; i < t.length(); i++){
            tCharCount[t.charAt(i)]++;
        }

        int start = 0,i= 0;
        int[] destHash = new int[128]; // 用于记录窗口内每个字母出现次数
        int found = 0;
        int begin = -1, end = s.length(), minLength = s.length();
        for (start = i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            destHash[ch]++;     // 每来一个字符给它的出现次数加1
            if (destHash[ch] <= tCharCount[ch]) found++;  // 匹配字符加1
            // 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
            if (found == t.length()) {
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
                for (ch = s.charAt(start); start < i && destHash[ch] > tCharCount[ch]; ch = s.charAt(++start)) {
                    destHash[ch]--;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if (i - start < minLength) {
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                // 把开头的这个匹配字符跳过，并将匹配字符数减1
                destHash[s.charAt(start)]--;
                found--;
                // 子串起始位置加1，我们开始看下一个子串了
                start++;
            }
        }
        // 如果begin没有修改过，返回空
        return begin == -1 ? "" : s.substring(begin,end + 1);

    }
}
