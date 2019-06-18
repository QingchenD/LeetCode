/**
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 *
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */

public class Rotate {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int boundaryLeft;
        int boundaryTop;
        int boundaryRight;
        int boundaryBottom;

        int squares = matrix.length / 2;
        int swap, swap2;
        for (int i = 0; i < squares; i++) {
            boundaryLeft = i;
            boundaryTop = i;
            boundaryRight = matrix[0].length - 1 - i;
            boundaryBottom = matrix.length - 1 - i;
            for (int j = boundaryLeft; j < boundaryRight; j++) {
                //top -> right
                swap = matrix[j][boundaryRight];
                matrix[j][boundaryRight] = matrix[boundaryTop][j];

                //right -> bottom
                swap2 = matrix[boundaryBottom][i + boundaryRight - j];
                matrix[boundaryBottom][i + boundaryRight - j] = swap;
                swap = swap2;

                // bottom -> left
                swap2 = matrix[i + boundaryRight - j][boundaryLeft];
                matrix[i + boundaryRight - j][boundaryLeft] = swap;
                swap = swap2;

                // left -> top
                matrix[boundaryTop][j] = swap;
            }
        }
    }
}
