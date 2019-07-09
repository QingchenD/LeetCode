package ljava;

import com.sun.javafx.binding.StringFormatter;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/144/
 *
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 *
 * 示例 2:
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 */


public class LongestIncreasingPath {
    int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; //便于写后面的越界判断
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int res = 1, m = matrix.length, n = matrix[0].length;//res为全局最长
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, dfs(matrix, dp, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];//该节点已记录最大长度
        int mx = 1, m = matrix.length, n = matrix[0].length;
        for (int[] a : dirs) {
            int x = i + a[0], y = j + a[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, dp, x, y);//优先进行深度搜索
            mx = Math.max(mx, len);
        }
        dp[i][j] = mx;
        System.out.println(String.format("dp[%d][%d] = %s", i, j, mx));
        return mx;
    }

}
