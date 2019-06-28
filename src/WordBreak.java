import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 */

public class WordBreak {

    /**
     *  算法：
     *    1. 这个问题具有最有子结构。利用数组存储前序比较的状态。
     *
     *  字符串s长度为n， wordDict个数：m
     *  时间复杂度：O(n*m)
     *  空间复杂度：o(n)
     *
     * 执行用时 :5 ms, 在所有 Java 提交中击败了91.34%的用户
     * 内存消耗 :34.8 MB, 在所有 Java 提交中击败了91.62%的用户
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;

        boolean[] bMatch = new boolean[s.length() + 1];
        bMatch[0] = true;
        return subWordBreak(s, bMatch, wordDict);
    }

    private boolean subWordBreak(String s, boolean[] bMatch, List<String> wordDict) {
        for (int i = 0; i < s.length(); i++) {
            if (bMatch[i]) {
                String subStr = s.substring(i);
                for (String word : wordDict) {
                    if (subStr.startsWith(word)) bMatch[i + word.length()] = true;
                }
            }
        }

        return bMatch[s.length()];
    }



    /**
     *  算法：
     *    1. 这个问题具有最有子结构。利用数组存储前序比较的状态。
     *    2. 利用HashSet存储wordDict，加快查找的速度。
     *
     *  字符串s长度为n， wordDict个数：m
     *  时间复杂度：O(n*m)
     *  空间复杂度：o(n)
     *
     * 执行用时 :4 ms, 在所有 Java 提交中击败了95.39%的用户
     * 内存消耗 :34.6 MB, 在所有 Java 提交中击败了95.18%的用户
     */

    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;

        boolean[] bMatch = new boolean[s.length() + 1];
        bMatch[0] = true;
        return subWordBreak(s, bMatch, new HashSet<>(wordDict));
    }

    private boolean subWordBreak(String s, boolean[] bMatch, HashSet<String> wordDict) {
        for (int i = 0; i < s.length(); i++) {
            if (bMatch[i]) {
                String subStr = s.substring(i);
                for (String word : wordDict) {
                    if (subStr.startsWith(word)) bMatch[i + word.length()] = true;
                }
            }
        }

        return bMatch[s.length()];
    }
*/

    /**
     * 回溯对于比较短的Stirng，还可以使用，对于比较长的S，太耗费时间。
     *
     * 字符串的长度为n. words的个数为m
     * 时间复杂度：O(m^n)
     * 空间复杂度：O(1)
     *  主要的内存消耗是m层递归调用占用的内存
     *
     *  算法时间复杂度太高，leetcode直接超时
     */

    /*
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;

        return subWordBreak(s, new HashSet<>(wordDict));
    }

    private boolean subWordBreak(String s, HashSet<String> wordDict) {
        if (s.length() == 0) return true;

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String sub = s.substring(word.length());
                if (subWordBreak(sub, wordDict)) return true;
            }
        }

        return false;
    }
    */
}
