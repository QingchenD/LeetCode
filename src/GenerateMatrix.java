import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int stepSize ;
        int circles = n >> 1;
        int restRow, restColumn;
        int value = 0;
        for (int i = 0; i <= circles; i++) {
            restRow = n - 2 * i;
            restColumn = n - i * 2;

            if (restRow > 0 && restColumn > 0) {
                // left -> right
                stepSize = restColumn;
                for (int j = 0; j < stepSize; j++) {
                    value++;
                    matrix[i][i + j] = value;
                }

                // up -> down
                stepSize = restRow;
                for (int j = 1; j < stepSize; j++) {
                    value++;
                   matrix[i + j][n - i - 1] = value;
                }
            }

            if (restRow > 1 && restColumn > 1) {
                // right -> left
                stepSize = restColumn;
                for (int j = 1; j < stepSize; j++) {
                    value++;
                    matrix[n - i - 1][n - 1 - i - j] = value;
                }

                // down -> up
                stepSize = restRow - 1;
                for (int j = 1; j < stepSize; j++) {
                    value++;
                    matrix[n - i - 1 - j][i] = value;
                }
            }
        }

        return matrix;
    }
}
