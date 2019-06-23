/**
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 */

public class RotateArray {


    /***
     * 每次移动K步，只适用一个额外的空间， 算法不太好理解。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * LeetCode : 1ms 超过98.46%的用户
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        int count = 0;

        for (int i = 0; i < k; i++) {
            int num = nums[i];
            int j = i;
            while (count < nums.length) {
                count++;
                int nextIndex = (j + k) % nums.length;
                int tmp = nums[nextIndex];
                nums[nextIndex] = num;
                num = tmp;
                j += k;
                if (nextIndex == i) break;
            }
        }

    }



    /***
     * 时间复杂度：O(n)
     * 空间复杂度：O(k)
     *
     * LeetCode : 1ms 超过98%的用户
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        if (k != 0) {
            int[] tmp = new int[k];
            System.arraycopy(nums, nums.length - k, tmp, 0, k);
            System.arraycopy(nums, 0, nums, k, nums.length - k);
            System.arraycopy(tmp, 0, nums, 0, k);
        }
    }
}
