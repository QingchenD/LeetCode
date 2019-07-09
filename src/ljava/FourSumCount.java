package ljava;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/125/
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输出:
 * 2
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 */

public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0 && B.length == 0 && C.length == 0 && D.length == 0) return 0;
        Integer res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum,  map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                res += map.getOrDefault(-sum, 0);
            }
        }

        return res;
    }
}
