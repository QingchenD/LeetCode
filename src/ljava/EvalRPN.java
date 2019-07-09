package ljava;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 *
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 *
 */

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        int m, n;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            //String sTrim = s.trim();
            switch (s) {
                case "+":
                    n = stack.pop();
                    m = stack.pop();
                    stack.push(n + m);
                    break;

                case "-":
                    n = stack.pop();
                    m = stack.pop();
                    stack.push(m - n);
                    break;

                case "*":
                    n = stack.pop();
                    m = stack.pop();
                    stack.push(n * m);
                    break;

                case "/":
                    n = stack.pop();
                    m = stack.pop();
                    stack.push(m / n);
                    break;

                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
}
