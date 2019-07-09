package ljava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/202/conclusion/792/
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 */

public class GetYanghuiRow {
    public List<Integer> getRow(int rowIndex) {
        int pre = 0, current = 0;
        Integer[] row = new Integer[rowIndex + 1];
        for (int i = 1; i <= row.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) { pre = 1; row[j] = 1; }
                else { current = row[j]; row[j] = pre + row[j]; pre = current; }
            }
        }

        return Arrays.asList(row);
    }
}
