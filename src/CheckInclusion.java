
/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1016/
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */

public class CheckInclusion {
    public boolean checkInclusion(final String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int [] count = new int [64];

        if(l1 > l2)
            return false;

        for(int i = 0; i < l1; i++){
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if(allZero(count))
            return true;

        for(int i = l1; i < l2; i++){
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - l1) - 'a']++;
            if(allZero(count))
                return true;
        }
        return false;
    }

    public boolean allZero(int [] count) {
        int l = count.length;
        for (int i = 0; i < l; i++) {
            if(count[i] != 0)
                return false;
        }
        return true;
    }


}
