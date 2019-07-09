package ljava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/62/math/164/
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 */

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, new StringsComparator());
        StringBuilder strBuilder = new StringBuilder();
        for(String str : strings) {
            strBuilder.append(str);
        }

        String result = strBuilder.toString();
        boolean allZero = true;
        // all 0 in nums
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') { allZero = false; break; }
        }

        return allZero? "0" : result;
    }

    class StringsComparator implements  Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String o2o1 = new StringBuilder(o2).append(o1).toString();
            String o1o2 = new StringBuilder(o1).append(o2).toString();
            return o2o1.compareTo(o1o2);
        }
    }
}
