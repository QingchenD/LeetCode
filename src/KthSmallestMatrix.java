import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 378. 有序矩阵中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 *
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 *
 */

public class KthSmallestMatrix {

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了97.09%的用户
     * 内存消耗 :49.9 MB, 在所有 Java 提交中击败了37.13%的用户
     *
     * 算法：
     *   1. 采用二分查找的方式，剔除所有比中间值Mid大的数据，就知道比小的等于Mid的数据有多少个。
     *   直至lo == hi，结束循环，lo就是要找的第K小的数据。
     *   2. 与mid值比较大小时，利用矩阵行列升序的特点。
     *
     * 时间复杂度：最坏情况O(n*n*logn)，最好情况：O(n*logn)，平均情况：O(n*n/2 * logn):
     * 空间复杂度：O(1)
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n-1][n-1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if (count < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }


    /**
     * 执行用时 :53 ms, 在所有 Java 提交中击败了24.69%的用户
     * 内存消耗 :50 MB, 在所有 Java 提交中击败了36.59%的用户
     *
     * 算法：
     *    K值大于矩阵数据量的一半时，就找第K小，等价于第（n * n + 1 - k）大的数据。
     *    可以减少内存的使用量，同时也可以减少每次的比较次数。
     *    但从测试结果来看，耗费的时间和内存都变大啦！！！
     *
     * 时间复杂度： O(n*n*logk)
     * 空间复杂度： O(k)
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        if (k > (n * n / 2)) {
            k = n * n + 1 - k;
            return kthBiggest(matrix, k);
        }

        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int[] nums : matrix) {
            for (int i : nums) {
                queue.add(i);
                if (queue.size() > k) queue.poll();
            }
        }
        return queue.poll();
    }

    private int kthBiggest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int[] nums : matrix) {
            for (int i : nums) {
                queue.add(i);
                if (queue.size() > k) queue.poll();
            }
        }
        return queue.poll();
    }


    /**
     * 执行用时 :35 ms, 在所有 Java 提交中击败了41.65%的用户
     * 内存消耗 :43.2 MB, 在所有 Java 提交中击败了96.48%的用户
     *
     * 时间复杂度 : O(n*n*logk)
     * 空间复杂度： O(k)
     *
     * 缺点没有利用Matrix，行列升序的特点。
     *
     */
    public int kthSmallest1(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int[] nums : matrix) {
            for (int i : nums) {
                queue.add(i);
                if (queue.size() > k) queue.poll();
            }
        }

        return queue.poll();
    }
}
