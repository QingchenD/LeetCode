/**
 * https://leetcode-cn.com/explore/interview/card/tencent/223/math-and-numbers/941/
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */

public class MajorityElement  {
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        for (Integer i : nums) {
            if (count == 0) {
                result = i;
                count++;
            } else if (result == i) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }

    public int majorityElement2(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; ++i) {
            int ones = 0, zeros = 0;
            for (int num : nums) {
                if (ones > n / 2 || zeros > n / 2) break;
                if ((num & (1 << i)) != 0) ++ones;
                else ++zeros;
            }
            if (ones > zeros) res |= (1 << i);
        }
        return res;
    }
}
