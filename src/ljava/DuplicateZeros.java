package ljava;

import java.util.ArrayList;
import java.util.List;

/**
 * 1089. 复写零
 * https://leetcode-cn.com/contest/weekly-contest-141/problems/duplicate-zeros/
 *
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 * 示例 1：
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 *
 * 示例 2：
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 * 提示：
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        if (arr == null) return;
        int[] res = new int[arr.length];
        for (int i = 0, j = 0; i < arr.length && j < res.length; i++, j++) {
            res[j] = arr[i];
            if (arr[i] == 0 && j + 1 < res.length ) res[++j] = 0;
        }

        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    /**
     * 速度很慢
     */
    public void duplicateZeros1(int[] arr) {
        if (arr == null) return;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for(int j = arr.length - 2; j > i; j --) {
                    arr[j + 1] = arr[j];
                }
                arr[++i] = 0;
            }
        }
    }
}
