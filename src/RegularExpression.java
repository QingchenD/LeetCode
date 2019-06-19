import java.util.Formatter;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *  s 可能为空，且只包含从 a-z 的小写字母。
 *  p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 *  示例 1:
 *  输入:
 *  s = "aa"
 *  p = "a"
 *  输出: false
 *  解释: "a" 无法匹配 "aa" 整个字符串。
 *
 */

public class RegularExpression {

    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();

    }

    public boolean isMatch1(String s, String p) {
        if (s == null || p == null) return false;
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() != 0 && p.length() == 0) return false;

        Stack<Integer> strStack = new Stack<>();
        Stack<Integer> patternStack = new Stack<>();

        int sIndex = 0;
        int pIndex = 0;
        int pre = -1;

        while (sIndex < s.length() && pIndex < p.length()) {
            char pChar = p.charAt(pIndex);
            if (pChar == '.') {
                strStack.push(sIndex);
                sIndex++;
                pIndex++;
            } else if (pChar == '*') {
                char pPreChar = p.charAt(pIndex - 1);
                char strChar = s.charAt(sIndex);
                if (pPreChar == strChar || pPreChar == '.') sIndex++;
                else pIndex++;
            } else if (pChar == s.charAt(sIndex)) {
                sIndex++;
                pIndex++;
            }
        }
        return true;
    }
}
