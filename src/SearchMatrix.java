/**
 * 240. 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 */

public class SearchMatrix {

    /**
     * 从右上角开始找，这个数字是上边和左边最大的数；
     * 算法时间复杂度o(n + M)， 类似于曼哈顿距离。
     * @param matrix
     * @param target
     * @return
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        //起点为最左上角的元素
        int row = 0, col = matrix[0].length - 1;
        //判断当前数组元素和target，如果当前大于target，往左走；小与target，往下走
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target){
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        //走出边界了还没找到，说明不存在，返回false
        return false;
    }




    /**
     * 利用数组的性质，找出目标数 所在区域的矩形框，然后再查找。
     * 平均可以减少一半的比较数量。
     * @param matrix
     * @param target
     * @return
     */

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;
        int left = row, top = col, right = 0, bottom = 0;
        //左右边界
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] <= target && matrix[row - 1][i] >= target) {
                left = Math.min(i, left);
                right = Math.max(i, right);
            }
        }

        //上下边界
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] <= target && matrix[i][col - 1] >= target) {
                top = Math.min(i, top);
                bottom = Math.max(i, bottom);
            }
        }

        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (matrix[i][j] == target) return true;
            }
        }

        return false;
    }


    /**
     *  每个比较一次， 速度不够快
     *  时间复杂度O(n*m)
     * @param matrix
     * @param target
     * @return
     */

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == target) return true;
            }
        }

        return false;

    }
}
