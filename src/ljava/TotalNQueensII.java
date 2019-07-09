package ljava;

import java.util.ArrayList;
import java.util.List;

/**
 * 52. N皇后 II
 * https://leetcode-cn.com/problems/n-queens-ii/
 *
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */

public class TotalNQueensII {
    private int total = 0;
    public int totalNQueens(int n) {
        if (n < 1) return 0;
        dfs(n, 0, new int[n]);
        return total;
    }

    private void dfs(int n , int index, int[] queens) {
        for (int i = 0; i < n; i++) {
            queens[index] = i;
            if (isMatch(queens, index)) {
                if (index == n -1) total++;
                else dfs(n, index + 1, queens);
            }
        }
    }

    private boolean isMatch(int[] queens, int index) {
        for (int i = 0; i < index; i++) {
            if (index - i == Math.abs(queens[index] - queens[i]) || queens[i] == queens[index]) {
                return false;
            }
        }

        return true;
    }
}
