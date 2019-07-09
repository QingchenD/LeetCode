package ljava;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/912/
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */


public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int stepSize = 0;
        int circles = rowSize >> 1;

        int restRow, restColumn;
        for (int i = 0; i <= circles; i++) {
            restRow = rowSize - 2 * i;
            restColumn = columnSize - i * 2;

            if (restRow > 0 && restColumn > 0) {
                // left -> right
                stepSize = restColumn;
                for (int j = 0; j < stepSize; j++) {
                    result.add(matrix[i][i + j]);
                }

                // up -> down
                stepSize = restRow;
                for (int j = 1; j < stepSize; j++) {
                    result.add(matrix[i + j][columnSize - i - 1]);
                }
            }

            if (restRow > 1 && restColumn > 1) {
                // right -> left
                stepSize = restColumn;
                for (int j = 1; j < stepSize; j++) {
                    result.add(matrix[rowSize - i - 1][columnSize - 1 - i - j]);
                }

                // down -> up
                stepSize = restRow - 1;
                for (int j = 1; j < stepSize; j++) {
                    result.add(matrix[rowSize - i - 1 - j][i]);
                }
            }

        }

        return result;
    }
}
