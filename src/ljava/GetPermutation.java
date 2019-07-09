package ljava;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1021/
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 *
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 *  参考资料：
 *  康托展开：https://zh.wikipedia.org/wiki/%E5%BA%B7%E6%89%98%E5%B1%95%E5%BC%80
 *
 */

public class GetPermutation {
    public String getPermutation(int n, int k) {
        int[] num = new int[n];
        int perNumCount = 1;

        for(int i = 0; i < n; i++) {
            num[i] = i+1;
            perNumCount *= i + 1;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            perNumCount = perNumCount / (n - i);
            int digit = k / perNumCount;
            sb.append(Integer.toString(num[digit]));
            System.arraycopy(num, digit + 1, num, digit, n - i - digit - 1);
            k = k % perNumCount;
        }
        return sb.toString();
    }
}
