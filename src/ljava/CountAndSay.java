package ljava;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 *
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 */

public class CountAndSay {
    private static HashMap<Integer, String>  countMap = createMap();
    private static HashMap<Integer, String> createMap() {
        HashMap<Integer, String>  map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "11");
        map.put(3, "21");
        map.put(4, "1211");
        map.put(5, "111221");
        map.put(6, "312211");
        map.put(7, "13112221");
        map.put(8, "1113213211");
        map.put(9, "31131211131221");
        map.put(10, "13211311123113112211");
        map.put(11, "11131221133112132113212221");
        map.put(12, "1");
        map.put(13, "1");
        map.put(14, "1");
        map.put(15, "1");
        map.put(16, "1");
        map.put(17, "1");
        map.put(18, "1");
        map.put(19, "1");
        map.put(20, "1");
        map.put(21, "1");
        map.put(22, "1");
        map.put(23, "1");
        map.put(24, "1");
        map.put(25, "1");
        map.put(26, "1");
        map.put(27, "1");
        map.put(28, "1");
        map.put(29, "1");
        map.put(30, "1");

        return map;
    }
    public String countAndSay(int n) {
        String str = null ;
        StringBuilder strBuilder = new StringBuilder("1");
        Character ch = null;
        int count = 0;
        for (int i = 1; i <= n ; i++) {
            str = strBuilder.toString();
            for (int j = 0; j < str.length(); j++) {
                if (j == 0) {
                    ch = str.charAt(0);
                    count = 1;
                    strBuilder = new StringBuilder();
                } else  {
                    if (ch == str.charAt(j)) {
                        count++;
                    }  else {
                        strBuilder.append(count + ch.toString());
                        ch = str.charAt(j);
                        count = 1;
                    }
                }

                if (j == str.length() - 1) {
                    strBuilder.append(count + ch.toString());
                    count = 0;
                }
            }
        }
        return str;
    }
}
