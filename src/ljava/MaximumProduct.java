package ljava;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 628. 三个数的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * 注意:
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 */

public class MaximumProduct {

    /**
     * 算法：
     *   可能存在负数，所以最大数，存在两种情况，最大三个数乘积 或 最大数乘于两个最小负数。
     *
     *  注意：
     *     1. 用最简单的硬找，最大值和最小值，反而最快。 如果使用堆排序，反而会因为装箱，拆箱的操作，减慢速度。
     *     2. 如果直接用快排，排序后计算，进行了太多的不必要比较，速度会慢6倍多。
     *
     * 执行用时 :4 ms, 在所有 Java 提交中击败了99.58%的用户
     * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了97.27%的用户
     */

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int i : nums) {
            //这样的if else 结果比并行的会更快
            if (i > max3) {
                max3 = i;
                if (i > max2) {
                    max3 = max2;
                    max2 = i;
                    if (i > max1) {
                        max2 = max1;
                        max1 = i;
                    }
                }
            }

            if (i < min2) {
                min2 = i;
                if (i < min1) {
                    min2 = min1;
                    min1 = i;
                }
            }

            //这样的 if else结构更好理解
            /*
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }

            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }
            */
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    /**
     * 执行用时 :26 ms, 在所有 Java 提交中击败了73.44%的用户
     * 内存消耗 :38.3 MB, 在所有 Java 提交中击败了98.02%的用户
     *
     * 用直接排序，可以减少一半的时间。
     * 直接用快排，时间复杂度o(nlogn), 时间复杂度并不是最优。 但仍然比堆排序快。
     */
    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);

        int rst = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        rst = Math.max(rst, nums[nums.length - 1] * nums[0] * nums[1]);

        return rst;
    }

    /**
     * 执行用时 :66 ms, 在所有 Java 提交中击败了5%的用户
     *
     * 使用堆排序，时间复杂度：o(nlog3)
     * 但运算中，有很多开箱，拆箱的转换，比较耗时。
     */
    public int maximumProduct1(int[] nums) {
        Queue<Integer> smallHeap = new PriorityQueue<>(3);
        Queue<Integer> bigHeapNegative = new PriorityQueue<>(2);   // 存储负数绝对值最大的数

        for (Integer i : nums) {
            smallHeap.add(i);
            if (smallHeap.size() > 3) smallHeap.poll();

            if (i < 0) {
                bigHeapNegative.add(-i);
                if (bigHeapNegative.size() > 2) bigHeapNegative.poll();
            }
        }

        int small = smallHeap.poll();
        int big = smallHeap.poll();
        int biggest = smallHeap.poll();

        int rst = Integer.MIN_VALUE;
        if (bigHeapNegative.size() >= 2) {
            rst = Math.max(rst, biggest * bigHeapNegative.poll() * bigHeapNegative.poll());
        }
        rst = Math.max(rst, small * big * biggest);

        return rst;
    }
}
