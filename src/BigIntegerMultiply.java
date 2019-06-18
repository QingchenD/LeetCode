/**
 *
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1015/
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */

public class BigIntegerMultiply {
    public String multiply(String num1, String num2) {
        char[] chars1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int[] nums = new int[chars1.length + chars2.length + 1];

        for (int i = 0; i < chars1.length ; i++) {
            for (int j = 0; j < chars2.length ; j++) {
                nums[i + j] += (chars1[i] - '0') * (chars2[j] - '0');
            }
        }

        //process carry
        int carry = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += carry;
            carry = nums[i] / 10;
            nums[i] %= 10;
        }

        StringBuilder result = new StringBuilder();
        boolean skipZero = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (skipZero) {
                if (nums[i] != 0) {
                    skipZero = false;
                    result.append(nums[i]);
                }
            } else {
                result.append(nums[i]);
            }
        }
        // result is 0
        if (result.length() == 0) result.append('0');

        return result.toString();
    }
}
