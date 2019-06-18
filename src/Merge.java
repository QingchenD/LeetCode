/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/231/apply-basic-algorithm-thinking/961/
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 */

public class Merge {
    //尾插法
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 || n == 0) {
            System.arraycopy(nums2, 0 , nums1, 0, n);
            return;
        }
        int last = m + n - 1;
        int i = m - 1, j = n - 1;

        while (last >= 0) {
            if ((i >= 0 && j >= 0 && nums1[i] >= nums2[j]) ||
                   (i >= 0 && j < 0)) nums1[last--] = nums1[i--];
            else nums1[last--] = nums2[j--];
        }
    }

    //头部开始 移动法
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while(j < n) {
            if (nums1[i] <= nums2[j]) {
                if (i < (m + j)) i++;
                else  nums1[i++] = nums2[j++];
            }
            else {
                System.arraycopy(nums1, i, nums1, i + 1, (m + n) - (i + 1));
                nums1[i++] = nums2[j++];
            }
        }
    }
}
