import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * https://leetcode-cn.com/explore/featured/card/tencent/223/math-and-numbers/940/
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */

public class SingleNumber {

    // 位与运算
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }

        return result;
    }

    // using hashset
    // very slow
    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : nums){
            if (!set.add(i)) {
                set.remove(i);
            }
        }

        return  set.iterator().next();
    }
}
