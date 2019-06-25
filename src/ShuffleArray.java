import java.util.Random;

/**
 * 384. 打乱数组
 * https://leetcode-cn.com/problems/shuffle-an-array/
 *
 * 打乱一个没有重复元素的数组。
 * 示例:
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 */

public class ShuffleArray {
    private int[] array;
    private int[] original;
    private Random random;
    public ShuffleArray(int[] nums) {
        original = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (original == null) return null;
        if (array == null) {
            array = new int[original.length];
        }
        System.arraycopy(original, 0, array, 0, array.length);

        for (int i = 0; i < array.length; i++) {
            int r = Math.abs(random.nextInt()) % array.length;
            int tmp = array[i];
            array[i] = array[r];
            array[r] = tmp;
        }

        return array;
    }
}
