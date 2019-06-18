/**
 *  https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 *  输入: "babad"
 *  输出: "bab"
 *  注意: "aba" 也是一个有效答案。
 */

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        String str = s.substring(0,1);
        int start = 0;
        int maxLength = str.length();
        for (int i = 0; i < s.length() ; i++) {

            //like "aba"
            int lo = i;
            int hi = i;
            while (s.charAt(lo) == s.charAt(hi)) {
                start = lo;
                maxLength = hi - lo + 1;
                if (lo == 0 || hi == s.length() -1) break;
                lo--;
                hi++;
            }
            if (str.length() < maxLength) {
                str = s.substring(start, start + maxLength);
            }

            //like "abba"
            lo = i;
            hi = i+1;
            while ((hi < s.length()) && (s.charAt(lo) == s.charAt(hi))) {
                start = lo;
                maxLength = hi - lo + 1;
                if (lo == 0 || hi == s.length() - 1) break;
                lo--;
                hi++;
            }
            if (str.length() < maxLength) {
                str = s.substring(start, start + maxLength);
            }
        }
        return str;
    }
}
