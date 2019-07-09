package ljava;

import java.util.Stack;

/**
 * 224. 基本计算器
 * https://leetcode-cn.com/problems/basic-calculator/
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 * 输入: "1 + 1"
 * 输出: 2
 *
 * 示例 2:
 * 输入: " 2-1 + 2 "
 * 输出: 3
 *
 * 示例 3:
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 *
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */

public class BasicCalculate {

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了96.26%的用户
     */
//    public int calculate(String s) {
//        return doCalculate(s.toCharArray(),0)[0];
//    }
//    public int[] doCalculate(char[] str,int i) {
//        int[] rst = new int[2];
//        int signal = 1;
//        int result = 0;
//        int n = 0;
//        while (i < str.length && str[i] != ')') {
//            if (str[i] == ' ') {
//                i++;
//            } else if (str[i] >= '0' && str[i] <= '9') {
//                n = n * 10 + str[i++] - '0';
//            } else if ( str[i] != '(') {
//                result += signal * n;
//                n = 0;
//                signal = str[i++] == '+' ? 1 : -1;
//            } else {
//                rst = doCalculate(str,i + 1);
//                n = rst[0];
//                i = rst[1] + 1;
//            }
//        }
//
//        result += signal * n;
//        rst[0] = result;
//        rst[1] = i;
//        return rst;
//    }


    /**
     *  16ms
     */
//    public int calculate(String s) {
//        Stack<Integer> stack = new Stack<>();
//        int ans = 0;    // 结果
//        int num = 0;    // 当前操作数
//        int sign = 1;   // 当前操作数应该被加还是被减
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (Character.isDigit(c)) {
//                num = 10 * num + (c - '0');
//            } else if (c == '+') {
//                ans += sign * num;
//                num = 0;
//                sign = 1;
//            } else if (c == '-') {
//                ans += sign * num;
//                num = 0;
//                sign = -1;
//            } else if (c == '(') {
//                /* we push the ans firstly, then push sign*/
//                stack.push(ans);
//                stack.push(sign);
//                // rest the sign and ans
//                sign = 1;
//                ans = 0;
//            } else if (c == ')') {
//                ans += sign * num;
//                num = 0;
//                ans *= stack.pop(); // stack.pop() is the sign before the parenthesis
//                ans += stack.pop(); // stack.pop() now is the ans calculated before the parenthesis
//            }
//        }
//        if (num != 0) {
//            ans += sign * num;
//        }
//        return ans;
//    }



    /**
     * 执行用时 :37 ms, 在所有 Java 提交中击败了64.21%的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了96.26%的用户
     */
    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int n = 0;
                while (i < s.length() && (c = s.charAt(i)) >= '0' && c <= '9') {
                    n = n * 10 + (c - '0');
                    i++;
                }
                numbers.push(n);
                doCalculate(operator, numbers);
            }

            if (c == '(' || c == '+' || c == '-') {
                operator.push(c);
            } else if (c == ')') {
                operator.pop();
                doCalculate(operator, numbers);
            }
        }
        return numbers.pop();
    }

    /**
     * 执行用时 :81 ms, 在所有 Java 提交中击败了47.37%的用户
     * 内存消耗 :40.9 MB, 在所有 Java 提交中击败了91.59%的用户
     */
//    public int calculate(String s) {
//        Stack<Integer> numbers = new Stack<>();
//        Stack<Character> operator = new Stack<>();
//
//        int n = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c >= '0' && c <= '9') {
//                n = n * 10 + (c - '0');
//                if (i + 1 == s.length()) {  // the last char
//                    numbers.push(n);
//                    doCalculate(operator, numbers);
//                    n = 0;
//                } else if (i + 1 < s.length()) {
//                    char nextChar = s.charAt(i + 1);
//                    if (!(nextChar >= '0' && nextChar <= '9')) {
//                        numbers.push(n);
//                        doCalculate(operator, numbers);
//                        n = 0;
//                    }
//                }
//            } else if (c == '(' || c == '+' || c == '-') {
//                operator.push(c);
//            } else if (c == ')') {
//                operator.pop();
//                doCalculate(operator, numbers);
//            }
//        }
//
//        return numbers.pop();
//    }

    private void doCalculate(Stack<Character> operator, Stack<Integer> numbers) {
        if (!operator.isEmpty() && operator.peek() != '(') {
            int signal = operator.pop() == '-' ? -1 : 1;
            int m = numbers.pop();
            int n = numbers.pop();
            numbers.push(n + signal * m);
        }
    }
}
