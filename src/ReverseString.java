/**
 * https://leetcode-cn.com/explore/featured/card/tencent/221/array-and-strings/905/
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。
 *
 * 输入: "hello"
 * 输出: "olleh"
 */

public class ReverseString {

    public String reverseString(String s) {
        if (s == null) return null;

        int length = s.length() - 1;
        StringBuilder strBuilder = new StringBuilder(s);
        for (int i = (length >> 1); i >= 0  ; i--) {
            char ch = strBuilder.charAt(i);
            strBuilder.setCharAt(i, strBuilder.charAt(length - i));
            strBuilder.setCharAt(length - i, ch);
        }

        return strBuilder.toString();
    }

    public String reverseString3(String s) {
        if (s == null) return null;

        int length = s.length() - 1;
        char[] str = s.toCharArray();
        for (int i = (length >> 1); i >= 0  ; i--) {
            char ch = str[i];
            str[i] = str[length - i];
            str[length - i] = ch;
        }

        return new String(str);
    }


    // use the standard library api
    public String reverseString2(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }
}
