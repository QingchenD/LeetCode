/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */

public class RainTrap {
    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;

        int lo = 0;
        int hi = height.length - 1;
        int lMax = height[lo];
        int hMax = height[hi];
        int ret = 0;

        while (lo < hi) {
            if (lMax < hMax) {
                lo++;
                if (height[lo] < lMax) ret += lMax - height[lo];
                else lMax = height[lo];
            } else {
                hi--;
                if (height[hi] < hMax) ret += hMax - height[hi];
                else hMax = height[hi];
            }
        }

        return ret;
    }
}
