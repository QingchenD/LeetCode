
/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1014/
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int shortestLength = getShortestLength(strs);
        if (shortestLength == 0) return "";

        int low = 0;
        int high = shortestLength;
        int length = (low + high) / 2;
        while (low < high) {
            if (allStringEqual(strs, length)) {
                low = length ;
            } else {
                high = length - 1;
            }
            length = ( low + high) / 2 + (low + high) % 2;

        }

        return length >= 1 ? strs[0].substring(0,length) : "";
    }

    private boolean allStringEqual(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        for (int i = 1; i < strs.length ; i++) {
            if (!strs[i].substring(0,length).equals(str0)) {
                return false;
            }
        }

        return true;
    }

    private int getShortestLength(String[] strs) {
        int length = Integer.MAX_VALUE;

        for (String str: strs) {
            if (str == null || str.length() == 0) {
               return 0;
            } else if (str.length() < length) {
                length = str.length();
            }
        }

        return length;
    }
}
