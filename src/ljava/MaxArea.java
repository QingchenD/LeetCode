package ljava;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */

public class MaxArea {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int result = 0;
        while (lo < hi) {
            result = Math.max(result, (hi - lo) * Math.min(height[lo], height[hi]));
            if ((height[lo] < height[hi])) lo++;
            else hi--;
        }

        return result;
    }
}
