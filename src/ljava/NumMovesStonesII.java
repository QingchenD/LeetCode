package ljava;

import java.util.Arrays;

/**
 * 1040. 移动石子直到连续 II
 * https://leetcode-cn.com/contest/weekly-contest-135/problems/moving-stones-until-consecutive-ii/
 *
 * 在一个长度无限的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作端点石子。
 * 每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。
 * 值得注意的是，如果石子像 stones = [1,2,5] 这样，你将无法移动位于位置 5 的端点石子，
 * 因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。当你无法进行任何移动时，即，
 * 这些石子的位置连续时，游戏结束。要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2
 * 的数组形式返回答案：answer = [minimum_moves, maximum_moves] 。
 *
 * 示例 1：
 * 输入：[7,4,9]
 * 输出：[1,2]
 * 解释：
 * 我们可以移动一次，4 -> 8，游戏结束。
 * 或者，我们可以移动两次 9 -> 5，4 -> 6，游戏结束。
 *
 * 示例 2：
 * 输入：[6,5,4,3,10]
 * 输出：[2,3]
 * 解释：
 * 我们可以移动 3 -> 8，接着是 10 -> 7，游戏结束。
 * 或者，我们可以移动 3 -> 7, 4 -> 8, 5 -> 9，游戏结束。
 * 注意，我们无法进行 10 -> 2 这样的移动来结束游戏，因为这是不合要求的移动。
 *
 * 示例 3：
 * 输入：[100,101,104,102,103]
 * 输出：[0,0]
 *
 * 提示：
 * 3 <= stones.length <= 10^4
 * 1 <= stones[i] <= 10^9
 * stones[i] 的值各不相同。
 *
 */
public class NumMovesStonesII {
    public int[] numMovesStonesII(int[] stones) {
        if (stones == null || stones.length < 3) return new int[] {0, 0};

        Arrays.sort(stones);

        return new int[] {findMinStep(stones), findMaxStep(stones)};
    }

    /**
     * 最大移动次数，就是找出最长距离，然后每次一步，往中间回滚。
     * 如 ： [1， 3， 9]
     * 回滚方式: [3,4,9] -> [4, 5, 9] -> [5,6,9] -> [6,7,9] -> [7, 8, 9]
     *
     * 中间最大距离： ditance = Math.max(9 - 3, 3-1) = 6
     * 中间空格数：distance - 1 = 5
     * 中间空格已占个数： length - 2 = 1   //不包含头尾。
     * 移动次数(算上第一次)： (中间空格数 - 空格已被占个数) + 1 = distance - 1 + (length - 2) + 1 = distance - length + 2
     *                                                  = 6 - 3 + 2 = 5
     */
    private int findMaxStep(int[] stones) {
        //选取左端点或者右端点后，剩下数字的最大间距
        int maxDistance = Math.max(stones[stones.length - 1] - stones[1], stones[stones.length - 2] - stones[0]);
        return maxDistance - stones.length + 2;
    }

    /**
     * 思路：
     *   找到一个区间，使得在length - 1的区间内，拥有的数字个数最多n。
     *   最小step = length - 1 - n + 1
     *   如果实际distance = length - 1 - 1; 则说明 一个孤立，其他数字是连续的，则至少需要2步
     *
     */
    private int findMinStep(int[] stones) {
        int distance = stones.length - 1;
        int count = 1;
        int maxCount = 0;
        int trueDistance = 0;
        int index = 0;
        for (int i = 0; i < stones.length && index < stones.length; i++) {
            int maxValue = stones[i] + distance;
            count--;
            while (index < stones.length) {
                if (stones[index] > maxValue) {
                    break;
                }
                index++;
                count++;
            }
            if (maxCount < count) {
                maxCount = count;
                trueDistance = stones[index - 1] - stones[i];
            }
        }

        return trueDistance == distance - 1 ? 2 : distance - maxCount + 1;
    }
}
