package ljava;

import java.util.*;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/138/
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 */

public class Solve {

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;

        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++){
            if(board[i][0] == 'O') merge(board,i,0);
            if(board[i][col-1] == 'O') merge(board,i,col-1);
        }
        for (int j = 0; j < col; j++){
            if(board[0][j] == 'O') merge(board,0,j);
            if(board[row-1][j] == 'O') merge(board,row-1,j);
        }
        // O->X  *->O
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    // connected 'O' -> '*'
    private void merge(char[][] board, int row, int col){
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;
        if (board[row][col] != 'O') return;

        board[row][col] = '*';
        merge(board,row,col + 1);
        merge(board,row + 1,col);
        merge(board,row - 1,col);
        merge(board,row,col - 1);
    }


    public void solve3(char[][] board) {
        if (board.length == 0) return;
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') helper(board,i,0);
            if (board[i][col-1] == 'O') helper(board,i,col-1);
        }

        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') helper(board,0,i);
            if (board[row-1][i] == 'O') helper(board,row-1,i);
        }

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '*') board[i][j] = 'O';
            }

    }

    private void helper(char[][] board , int x, int y) {

        int[][] nums = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] integers = {x,y};
        queue.offer(integers);
        board[x][y] = '*';

        while (queue.size() > 0){
            Integer[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                Integer newX = temp[0] + nums[i][0];
                Integer newY = temp[1] + nums[i][1];
                if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) continue;

                if (board[newX][newY] == 'O'){
                    board[newX][newY] = '*';
                    Integer[] t = {newX, newY};
                    queue.offer(t);
                }
            }
        }
    }

    public void solve2(char[][] board) {
        if (board == null || board.length < 2) return;

        Set<Pair> set = new HashSet<>();

        // top and bottom
        for (int i = 0; i < board[0].length; i++) {
            buildConnectedArea(set, board,new Pair(0, i));
            buildConnectedArea(set, board,new Pair(board.length - 1, i));
        }

        //left and right
        for (int i = 0; i < board.length; i++) {
            buildConnectedArea(set, board,new Pair(i, 0));
            buildConnectedArea(set, board,new Pair(i, board[0].length - 1));
        }

        //change 'O' to 'X' in the middle
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (!set.contains(new Pair(i,j))) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void buildConnectedArea(Set<Pair> set, char[][] board, Pair pair) {
        int row = pair.key;
        int column = pair.value;
        if (board[row][column] == 'O' && set.add(pair)) {
            if (row - 1 >= 0)  buildConnectedArea(set,board, new Pair(row - 1, column));
            if (row + 1 < board.length)  buildConnectedArea(set,board, new Pair(row + 1, column));
            if (column - 1 > 0) buildConnectedArea(set,board, new Pair(row, column - 1));
            if (column + 1 < board[0].length) buildConnectedArea(set,board, new Pair(row, column + 1));
        }
    }

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return key << 16 + value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                return (pair.key == this.key && pair.value == this.value);
            }
            return false;
        }
    }
}
