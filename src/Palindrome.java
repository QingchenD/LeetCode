import com.sun.javafx.binding.StringFormatter;
import com.sun.org.apache.regexp.internal.RE;

import java.util.regex.Pattern;

/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/232/two-pointers/965/
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 */

public class Palindrome {
    public boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;

        while (lo < hi) {
            if (!isMatch(s.charAt(lo))) lo++;
            else if (!isMatch(s.charAt(hi))) hi--;
            else if (toLowerCase(s.charAt(lo)) != toLowerCase(s.charAt(hi))) return false;
            else { lo++; hi--; }
        }

        return true;
    }

    private boolean isMatch(char ch) {
        return  ((ch >= 'a' && ch <= 'z') ||
                (ch >= 'A' && ch <= 'Z')  ||
                (ch >= '0' && ch <= '9')) ;
    }

    private char toLowerCase( char ch) {
        if (ch >= 'A' && ch <= 'Z') return (char)(ch + 0x20);
        return ch;
    }
}
