package ljava;


/**
 * 383. 赎金信
 * https://leetcode-cn.com/problems/ransom-note/
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Ransom {

    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了94.69%的用户
     * 内存消耗 :46.3 MB, 在所有 Java 提交中击败了78.81%的用户
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) return true;
        else if (magazine == null || magazine.length() == 0) return false;

        int[] count = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']--;
        }

        for (int i : count) {
            if (i > 0) return false;
        }
        return true;
    }
}
