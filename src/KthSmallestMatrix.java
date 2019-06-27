import java.util.Comparator;
import java.util.LinkedList;
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
     * 执行用时 :53 ms, 在所有 Java 提交中击败了24.69%的用户
     * 内存消耗 :50 MB, 在所有 Java 提交中击败了36.59%的用户
     */
    public int kthSmallest(int[][] matrix, int k) {
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
     * 时间复杂度 : O(n*n)
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
