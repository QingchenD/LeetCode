import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/908/
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 */

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }

        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}
