/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1011/
 *
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 *
 * 说明:
 *   无空格字符构成一个单词。
 *   输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *   如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */

public class ReverseWords {

    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder strBuild = new StringBuilder();
        for (int i = strs.length - 1 ; i >= 0; i--) {
            if (!strs[i].equals("")) {
                strBuild.append(strs[i]);
                strBuild.append(" ");
            }
        }
        return strBuild.toString().trim();
    }

    /**
     *  速度很慢
     */
    public String reverseWords1(String s) {
        String str = s.replaceAll("\\s+", " ");
        String[] strs = new StringBuilder(str).reverse().toString().split(" ");
        StringBuilder strBuild = new StringBuilder();
        for (String string : strs) {
            strBuild.append(new StringBuilder(string).reverse());
            strBuild.append(" ");
        }
        return strBuild.toString().trim();
    }

    //这个和上面的作用不一样： 反转字符串中的单词 III
    //https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
    //just reverse words
    //输入: "Let's take LeetCode contest"
    //输出: "s'teL ekat edoCteeL tsetnoc"
    public String reverseWords2(String s) {
        String[] strs = s.split(" ");
        StringBuilder strBuild = new StringBuilder();
        for (String string : strs) {
            strBuild.append(new StringBuilder(string).reverse());
            strBuild.append(" ");
        }
        return strBuild.toString().trim();
    }
}
