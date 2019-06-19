import java.util.Stack;

/**
 * 85. 最大矩形
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                // update the state of this row's histogram using the last row's histogram
                // by keeping track of the number of consecutive ones
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            // update maxarea with the maximum area from this row's histogram
            maxarea = Math.max(maxarea, largestRectangleArea(dp));
        } return maxarea;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        Stack< Integer > stack = new Stack < > ();
        stack.push(-1);
        long largestArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                largestArea = Math.max(largestArea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            largestArea = Math.max(largestArea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return (int)largestArea;
    }
}
