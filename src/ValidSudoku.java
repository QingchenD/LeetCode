import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 36. 有效的数独
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可.
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;

        Set<Character> set = new HashSet<>();

        //判断行是否有效
        for(char[] chars : board) {
            for (char ch : chars) {
                if (ch != '.' && !set.add(ch))
                    return false;
            }
            set.clear();
        }

        //判断列是否有效
        for (int c = 0; c < 9 ; c++ ) {
            for (int r = 0; r < 9 ; r++) {
                if (board[r][c] != '.' && !set.add(board[r][c]))
                    return false;
            }
            set.clear();
        }

        //判断9个9宫格
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i * 3;
                int col = j * 3;
                for (int r = row; r < row + 3; r ++) {
                    for (int c = col; c < col + 3; c++) {
                        if (board[r][c] != '.' && !set.add(board[r][c]))
                            return false;
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
