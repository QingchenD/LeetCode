package ljava;

/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/232/two-pointers/967/
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 *
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 */

public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int lo = 0;
        int hi = str.length - 1;
        while (lo < hi) {
            if (!isVowel(str[lo])) lo++;
            else if (!isVowel(str[hi])) hi--;
            else {
                swapChar(str, lo, hi);
                lo++;
                hi--;
            }
        }

        return new String(str);
    }

    private boolean isVowel(char ch) {
        return  (ch == 'a' || ch == 'A' ||
                 ch == 'e' || ch == 'E' ||
                 ch == 'i' || ch == 'I' ||
                 ch == 'o' || ch == 'O' ||
                 ch == 'u' || ch == 'U');
    }

    private void swapChar(char[] chars, int i, int j) {
        char swap = chars[i];
        chars[i] = chars[j];
        chars[j] = swap;
    }
}
