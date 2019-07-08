/**
 * https://leetcode-cn.com/explore/interview/card/tencent/223/math-and-numbers/938/
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 */

public class ReverseNumber {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = res * 10 + x % 10;
            if(temp / 10 != res)
                return 0;
            res = temp;
            x /= 10;
        }
        return res;
    }

    /**
     * 9ms 超过27%的用户
     */
    public int reverse1(int x) {
        int result = 0;
        int flag = 1;
        if (x < 0) flag = -1;

        StringBuilder strBuilder = new StringBuilder(Integer.valueOf(Math.abs(x)).toString());
        strBuilder.reverse();
        try {
            result = Integer.valueOf(strBuilder.toString()) * flag;
        } catch (NumberFormatException ne) {
            // ne.printStackTrace();
        }
        return result;
    }
}
