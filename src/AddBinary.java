import org.omg.PortableInterceptor.INACTIVE;

/**
 *  https://leetcode-cn.com/problems/add-binary/
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        char[] result = new char[length + 1];
        char ach, bch;
        int carry = 0, sum;
        for (int i = 0; i < length; i++) {
            if (a.length() - 1 - i >= 0) ach = a.charAt(a.length() - 1 - i);
            else ach = '0';

            if (b.length() - 1 - i >= 0) bch = b.charAt(b.length() - 1 - i);
            else bch = '0';

            sum = ach - '0' + bch - '0' + carry;
            result[result.length - 1 - i] = (char)(sum % 2 + '0');
            carry = sum / 2;
        }

        int start = 1;
        if (carry > 0) {
            result[0] = '1';
            start = 0;
        }
        return new String(result, start, result.length - start);

        //return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
}
