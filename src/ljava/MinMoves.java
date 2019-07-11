package ljava;


/**
 * 453. 最小移动次数使数组元素相等
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 *
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
 *
 * 示例:
 * 输入:
 * [1,2,3]
 * 输出:
 * 3
 *
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 */
public class MinMoves {
    /**
     * 每次将n-1个元素加1，相当于将一个元素-1，之后整体相对大小关系不变。
     * 所以每个数减到和最小值相等即可。可以在线性时间内完成，时间复杂度是O(N)。
     */
    public int minMoves(int[] nums) {
        if (nums.length < 2) return 0;

        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }

        int rst = 0;
        for(int i: nums) {
            rst += i - min;
        }
        return rst;
    }
}
