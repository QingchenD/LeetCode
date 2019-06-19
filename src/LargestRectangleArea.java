import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *  
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 */


public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        long largestArea = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.size() == 0) stack.push(i);
            else {
                index = stack.peek();
                if (heights[i] >= heights[index]) stack.push(i);
                else {
                    while (stack.size() > 0 && heights[stack.peek()] > heights[i]) {
                        index = stack.pop();
                        largestArea = Math.max((long)(i - index) * heights[index], largestArea);
                    }

                    stack.push(i);
                }
            }
        }

        if (stack.size() > 0) {
            int last = stack.peek();
            while (stack.size() > 1) {
                index = stack.pop();
                largestArea = Math.max((last + 1 - index) * heights[index], largestArea);
            }

            //最小的height
            largestArea = Math.max(heights.length * (long)heights[stack.peek()], largestArea);
        }


        return (int)largestArea;
    }


    /**
     * 速度不够快
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        long largestArea = 0;
        for (int i = 0; i < heights.length; i++) {
            long minHeight = heights[i];
            long maxArea = 0;
            for(int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight,heights[j]);
                maxArea = Math.max(minHeight * (j - i + 1), maxArea);

                if ((largestArea - maxArea) >= (minHeight * (heights.length - (j + 1)))) break;
            }

            largestArea = Math.max(maxArea, largestArea);
        }

        return (int)largestArea;
    }
}
