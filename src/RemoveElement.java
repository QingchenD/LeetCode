/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/230/define-with-good-care/951/
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */

public class RemoveElement {
    //使用快慢指针
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value != val) {
                nums[index++] = value;
            }
        }

        return index;
    }


    //使用copy
    //优点：实现逻辑简单
    //缺点：速度上优势不大
    public int removeElement2(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] == val) {
                System.arraycopy(nums, index + 1, nums, index, nums.length - (index + 1));
            } else {
                index++;
            }
        }

        return index;
    }
}
