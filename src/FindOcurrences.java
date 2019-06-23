import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 1078. Bigram 分词
 * https://leetcode-cn.com/contest/weekly-contest-140/problems/occurrences-after-bigram/
 *

 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 * 示例 1：
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 *
 * 示例 2：
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 *
 * 提示：
 * 1 <= text.length <= 1000
 * text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
 * 1 <= first.length, second.length <= 10
 * first 和 second 由小写英文字母组成
 */

public class FindOcurrences {

    /**
     * 分割字符串时，使用text.split(" "); 可以通过leetcode测试： 2ms
     * 如果使用text.split("\\s+")； 则耗时是9ms; 慢了4倍多。
     * 但是个人觉得word之间可能有多个空格，如果使用text.split(" ")，则可能找不出第三个String
     */

    public String[] findOcurrences(String text, String first, String second) {
        List<String> rst = new ArrayList<>();

        String[] words = text.split(" ");
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                rst.add(words[i + 2]);
            }
        }

        return rst.toArray(new String[0]);
    }

    /**
     * leetCode : 8ms 超过 6.37%的用户
     */
    public String[] findOcurrences1(String text, String first, String second) {
        List<String> rst = new ArrayList<>();
        int firstIndex = Integer.MAX_VALUE;
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals(first)) firstIndex = i;
            else if (words[i].equals(second)) {
                if (i - firstIndex == 1) {
                    rst.add(words[i + 1]);
                }
            }
        }

        return rst.toArray(new String[0]);
    }
}
