package ljava;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 475. 供暖器
 * https://leetcode-cn.com/problems/heaters/
 *
 *
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 *  说明:
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * 示例 1:
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 *
 * 示例 2:
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 */
public class FindRadius {

    /**
     * 执行用时 :27 ms, 在所有 Java 提交中击败了41.64%的用户
     * 内存消耗 :49.1 MB, 在所有 Java 提交中击败了48.27%的用户
     */
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int minDistance = Integer.MAX_VALUE;
            int lo = 0;
            int hi = heaters.length - 1;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (house == heaters[mid]) {
                    minDistance = 0;
                    break;
                } else if (house > heaters[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (minDistance != 0) {
                minDistance = Math.min(Math.abs(heaters[lo] - house), minDistance);
                if (lo - 1 >= 0) {
                    minDistance = Math.min(Math.abs(heaters[lo - 1] - house), minDistance);
                }
                if (lo + 1 <= heaters.length - 1) {
                    minDistance = Math.min(Math.abs(heaters[lo + 1] - house), minDistance);
                }
            }

            radius = Math.max(radius, minDistance);
        }
        return radius;
    }
}
