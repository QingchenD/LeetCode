/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/230/define-with-good-care/955/
 *
 *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */

public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;

        int index = 1;
        int preNums = nums[0];
        int duplicateCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == preNums) {
                if (++duplicateCount <= 2) {
                    nums[index++] = preNums;
                }
            } else {
                preNums = nums[i];
                duplicateCount = 1;
                nums[index++] = preNums;
            }
        }

        return index;
    }


    //每次都移动所有的数据,速度很慢
    public int removeDuplicates2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index + 2 < nums.length && nums[index] == nums[index + 2 ]) {
                System.arraycopy(nums,index + 2, nums, index + 1, nums.length - (index + 2));
                nums[nums.length - 1] = nums[0] - 1;
            } else {
                index++;
            }
        }

        return index;
    }
}
