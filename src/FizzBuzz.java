import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/25/math/60/
 *
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 * n = 15,
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 *
 */

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        String STR_DIV3_DIV5 = "FizzBuzz";
        String STR_DIV3 = "Fizz";
        String STR_DIV5 = "Buzz";
        List<String> strList = new ArrayList<>();
        int div3, div5;
        for (int i = 1; i <= n ; i++) {
            div3 = i % 3;
            div5 = i % 5;
            if (div3 == 0 && div5 == 0) {
                strList.add(STR_DIV3_DIV5);
            } else if (div3 == 0) {
                strList.add(STR_DIV3);
            } else if (div5 == 0) {
                strList.add(STR_DIV5);
            } else {
                strList.add(String.valueOf(i));
            }
        }

        return strList;
    }
}
