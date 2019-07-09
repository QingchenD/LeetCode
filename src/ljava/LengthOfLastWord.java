package ljava;

/**
 *
 * https://leetcode-cn.com/problems/length-of-last-word/
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 */


public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;

        int end = -1;
        int start = -1;
        char[] str = s.toCharArray();
        for (int i = str.length - 1; i >= 0; i--) {
            if (end < 0) {
                if (str[i] != ' ') end = i;
            } else {
                if (str[i] == ' ') { start = i; break; }
            }
        }
        return end - start;
    }


    // not fast enough
    public int lengthOfLastWord2(String s) {
        if (s == null) return 0;

        String[] strs = s.split(" ");
        return strs.length == 0 ? 0 : strs[strs.length - 1].length();
    }
}
