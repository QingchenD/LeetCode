package ljava;

import java.util.Stack;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/131/
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 *
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 *
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 *
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 */

public class Calculate {
    public int calculate(String s) {
        int num = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            }

            if ((ch < '0' && ch != ' ') || i == s.length() - 1) {
                if (op == '+') stack.push(num);
                else if (op == '-') stack.push(-num);
                else if (op == '*' || op == '/') {
                    int tmp = (op == '*') ? stack.pop() * num : stack.pop() / num;
                    stack.push(tmp);
                }
                op = ch;
                num = 0;
            }
        }

        int result = 0;
        while (stack.size() > 0 ) {
            result += stack.pop();
        }

        return result;
    }
}
