package ljava;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后
 * https://leetcode-cn.com/problems/n-queens/
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例:
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 */

public class SolveNQueens {

    List<List<String>> rst = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return null;
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '.';
        }
        int[] queens = new int[n];
        dfs(n, 0, queens, chars);

        return rst;
    }

    private void dfs(int n , int index, int[] queens, char[] chars) {
        if (index == queens.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                StringBuilder s = new StringBuilder().append(chars);
                s.setCharAt(queens[i], 'Q');
                list.add(s.toString());
            }
            rst.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            queens[index] = i;
            if (isMatch(queens,index)) {
                dfs(n, index + 1, queens, chars);
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
