/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 *
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */

public class ZConvert {

    public String convert(String s, int numRows) {
        /** if k == 4 ,the index :
         *  1) number index:  0, 6, 12
         *  2) number index:  1, 5, 7, 11, 13
         *  3) number index:  2, 4, 8, 10, 14
         *  4) number index:  3, 9, 15
         *
         *  算法：
         *  1）  0 + 2*(k - 1) * n  , 0 + 2*(k - 1) * n  + 2*(k-1)
         *  2）  1 + 2*(k - 1) * n  , 1 + 2*(k - 1) * n  + 2*(k-2)
         *  3）  2 + 2*(k - 1) * n  , 2 + 2*(k - 1) * n  + 2*(k-3)
         *  4）  3 + 2*(k - 1) * n  , 3 + 2*(k - 1) * n  + 2*(k-4)
         *
         *  i，j start from 0:
         *  interval = 2 * (numRows - 1);
         *  index = i + interval * j， index + 2 * (numRows - (i + 1))
         */

        if (numRows == 1) return s;

        int index = 0;
        int j = 0;
        int interval = 2 * (numRows - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            j = 0;
            while (true) {
                index = i + interval * j;
                if (index >= s.length()) break;
                stringBuilder.append(s.charAt(index));

                if (i != 0 && i != numRows -1) {
                    index = index + 2 * (numRows - (i + 1));
                    if (index < s.length()) {
                        stringBuilder.append(s.charAt(index));
                    }
                }

                j++;
            }
        }

        return stringBuilder.toString();
    }
}
