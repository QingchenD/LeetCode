package ljava;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 * https://leetcode-cn.com/contest/weekly-contest-141/problems/shortest-path-in-binary-matrix/
 *
 * 题目难度 Medium
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 * 示例 1：
 * 输入：[[0,1],[1,0]]
 * 输出：2
 *
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 */


public class ShortestPathBinaryMatrix {

    /**
     *  leetCod : 31ms
     *  超过95%的用户
     */

    private int[][] offsets = { {-1, -1}, {-1, 0}, {-1, 1},
                                {0, -1},          {0, 1},
                                {1, -1}, {1, 0},  {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) return -1;

        Queue<Node> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int[][] rst = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rst[i][j] = Integer.MAX_VALUE;
            }
        }

        if (grid[0][0] == 0) {
            rst[0][0] = 1;
            queue.add(new Node(0, 0));
        }
        bfs(grid, rst, queue);
        return rst[row -1][col - 1] == Integer.MAX_VALUE ? -1 : rst[row -1][col - 1];
    }

    private void bfs(int[][] grid, int[][] rst, Queue<Node> queue) {
        if (queue.size() == 0) return;

        int row = grid.length;
        int col = grid[0].length;

        Node node = queue.poll();
        int i = node.row;
        int j = node.col;

        for (int[] offset : offsets ) {
            int x = i + offset[0];
            int y = j + offset[1];
            if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 0) {
                if (rst[x][y] > rst[i][j] + 1) {
                    rst[x][y] = rst[i][j] + 1;
                    queue.add(new Node(x, y));
                }
            }
        }
        bfs(grid, rst, queue);
    }

    class Node {
        int row;
        int col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
