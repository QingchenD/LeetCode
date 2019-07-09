package ljava;

/**
 * 371. 两整数之和
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */

public class GetSum {
    public int getSum(int a, int b) {
        int and = a & b; //与运算结果，1的位代表两个数值都为1，存在进位
        int eor = a ^ b; //异或运算结果，1的位代表两个数值对应位有一个为1

        //若and不为0，意味着存在进位情况，将进位左移
        if(and != 0) {
            and = and << 1;
        }

        //当进位为1的位数和有一位为1的位数相遇，与运算为1，证明再次存在进位运算
        while((and & eor) != 0){
            //计算新的进位
            int newAnd = and & eor;
            //再次比较出有一位为1的位数
            eor = and ^ eor;
            //把进位左移
            and = newAnd <<1;
        }
        //进位和有一位为1的位已经没有重叠，通过异或运算得出最终位数状态
        //为什么用抑或而不是或运算，因为之前应该进位的位没有改为0，
        //而该进的位已经写到最终的位
        return and ^ eor;
    }
}
