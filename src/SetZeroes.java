/**
 * 73 矩阵置零
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 示例 2:
 * 输入:
 * [
 *  [0,1,2,0],
 *  [3,4,5,2],
 *  [1,3,1,5]
 * ]
 * 输出:
 * [
 *  [0,0,0,0],
 *  [0,4,5,0],
 *  [0,3,1,0]
 * ]
 *
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */

public class SetZeroes {

    /**
     * 时间复杂度:o(mn)
     * 空间复杂度:O(1)
     *
     * 执行用时 :3 ms, 在所有 Java 提交中击败了83.71%的用户
     * 内存消耗 :52.2 MB, 在所有 Java 提交中击败了51.68%的用户
     *
     * 按理说空间复杂度降低，占用的空间会变少，但是这里却增加了，？？？？
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int row = matrix.length;
        int col = matrix[0].length;

        int r = -1 , c = -1;

        //记录为0的行和列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                   if (r == -1) {
                       r = i;
                       c = j;
                   } else {
                       matrix[r][j] = 0;
                       matrix[i][c] = 0;
                   }
                }
            }
        }

        if (r == -1) return;

        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();

        //设置行为0
        for (int i = 0; i < row; i++) {
            if (matrix[i][c] == 0) {
                if (i != c) {
                    for (int j = 0; j < col; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        //设置列为0
        for (int i = 0; i < col; i++) {
            if (matrix[r][i] == 0) {
                if (i != c) {
                    for (int j = 0; j < row; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < col; i++) {
            matrix[r][i] = 0;
        }
        for (int i = 0; i < row; i++) {
            matrix[i][c] = 0;
        }
    }


    /**
     * 时间复杂度:o(mn)
     * 空间复杂度:O(m + n)
     *
     * 执行用时 :3 ms, 在所有 Java 提交中击败了83.71%的用户
     * 内存消耗 :52.2 MB, 在所有 Java 提交中击败了51.68%的用户
     *
     * 按理说空间复杂度降低，占用的空间会变少，但是这里却增加了，？？？？
     * 不过空间复杂度降低后，用时减少了 40%。
     */
    public void setZeroes2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int row = matrix.length;
        int col = matrix[0].length;

        int[] r = new int[row];
        int[] c = new int[col];

        //记录为0的行和列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    r[i] = 1;
                    c[j] = 1;
                }
            }
        }

        //设置行为0
        for (int i = 0; i < r.length; i++) {
            if (r[i] == 1) {
                for (int j = 0; j < c.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        //设置列为0
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 1) {
                for (int j = 0; j < r.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }


    /**
     * 时间复杂度: O(m*n)
     * 空间复杂度：O(m*n)
     *
     * leetcode :
     * 执行用时 :5 ms, 在所有 Java 提交中击败了31.79%的用户
     * 内存消耗 :48.8 MB, 在所有 Java 提交中击败了79.43%的用户
     */
    public void setZeroes1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] backup = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(matrix[i], 0, backup[i], 0, col);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backup[i][j] == 0) {
                    for(int k = 0; k < col; k++) {
                        matrix[i][k] = 0;
                    }

                    for (int k = 0; k < row; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}
