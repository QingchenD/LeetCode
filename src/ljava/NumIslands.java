package ljava;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */

public class NumIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int lands = 0;

        for ( int i = 0 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);

                    lands++;
                }
            }
        }

        return lands;
    }

    private void bfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length) return;
        if (col < 0 || col >= grid[0].length) return;

        if (grid[row][col] == '1') {
            grid[row][col] = '0';
            bfs(grid, row - 1, col);
            bfs(grid, row + 1, col);
            bfs(grid, row, col - 1);
            bfs(grid, row, col + 1);
        }
    }

    /**
     *  不修改原始数组：但速度慢，且耗内存多
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int[][] offsets = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Node> queue = new LinkedList<>();
        BitSet bitSet = new BitSet();
        int row = grid.length;
        int col = grid[0].length;
        int lands = 0;

        for ( int i = 0 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !bitSet.get(i * col + j)) {
                    bitSet.set(i*col + j);
                    queue.add(new Node(i,j));

                    do {
                        Node node = queue.poll();
                        int r, c;
                        for (int[] offset : offsets) {
                            r = node.row + offset[0];
                            c = node.col + offset[1];
                            if (r >= 0 && r < row && c >= 0 && c < col &&
                                    grid[r][c] == '1' &&
                                    !bitSet.get(r * col + c)) {
                                queue.add(new Node(r, c));
                                bitSet.set(r * col + c);
                            }
                        }
                    } while (queue.size() > 0);

                    lands++;
                }
            }
        }

        return lands;
    }



    class Node {
        private int row;
        private int col;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
