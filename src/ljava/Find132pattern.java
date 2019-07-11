package ljava;

/**
 * 456. 132模式
 * https://leetcode-cn.com/problems/132-pattern/
 *
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：
 * 当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，
 * 验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 * 输入: [1, 2, 3, 4]
 * 输出: False
 * 解释: 序列中不存在132模式的子序列。
 *
 * 示例 2:
 * 输入: [3, 1, 4, 2]
 * 输出: True
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 *
 * 示例 3:
 * 输入: [-1, 3, 2, 0]
 * 输出: True
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 */
public class Find132pattern {

    /**
     * 算法：
     *   1. 利用Stack 记录3的值
     *   2. 利用变量second记录2的值。
     *   3. 倒序遍历数组，当前值为1值， 如果当前值小于second，则return true。
     *
     * 执行用时 :4 ms, 在所有 Java 提交中击败了99.26%的用户
     * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了94.66%的用户
     */
    public boolean find132pattern2(int[] nums) {
        int len = nums.length;
        int top = -1;
        int[] stack = new int[len]; // 记录132的3
        int second = Integer.MIN_VALUE; // 记录132的2
        for (int i = len - 1; i >= 0; i--) { // num[i] 当前132的1
            if (nums[i] < second) {
                return true;
            }
            while (top != -1 && stack[top] < nums[i]) {  //如果当前值大于3值，则取出值，赋值给2.
                second = stack[top--];
            }
            stack[++top] = nums[i];                    //当前值，赋值给3
        }
        return false;
    }

    /**
     * 执行用时 :433 ms, 在所有 Java 提交中击败了25.46%的用户
     * 内存消耗 :47.1 MB, 在所有 Java 提交中击败了80.91%的用户
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度: O（1）
     *
     * 按理说O(1)的空间复杂度，占用的内存空间会少些，但从测试结果看，比O(n)的占用的空间还高
     * 根据这个怀疑，再提交上面的算法，消耗时间4ms,占用内存50.7M，比算法占用内存大。
     * 从测试结果看，LeetCode 运行时占用内存统计，不太准确。
     */
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;

        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min); // 找到最小值即1
            if (nums[i] == min) { //若nums[i] != min 则，出现132的13
                continue;
            }

            for (int j = nums.length - 1; j > i; j--) {
                if (min < nums[j] && nums[j] < nums[i]) {  //若出现32则返回正确
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 思路：
     *   132的模式的数据，就是锯齿状的数据，先找出锯齿的顶端
     *   1. diff从正向扫描，记录diff[i] = num[i] - num[j]
     *   2. reverseDiff从反向扫描，记录reverseDiff = num[i] - num[i - 1]
     *   3. diff[i] 与 reverseDiff[i] 都大于或者等于，则是顶端。
     *   4. 再从顶端往左找，小于num[i] 的最小值min。往右找小于num[i]的最大值max，
     *      若，min < max , 返回True。 否则跳到3继续。
     *
     * 执行用时 :681 ms, 在所有 Java  提交中击败了12.55%的用户
     * 内存消耗 :50.4 MB, 在所有 Java 提交中击败了28.24%的用户
     */
    public boolean find132pattern1(int[] nums) {
        if (nums.length < 3) return false;

        int[] diff = new int[nums.length];
        for (int i = 0 ; i < nums.length - 1; i++) {
            diff[i] = nums[i] - nums[i + 1];
        }

        int[] reverseDiff = new int[nums.length];
        for (int i = nums.length - 1 ; i > 0; i--) {
            reverseDiff[i] = nums[i] - nums[i - 1];
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (diff[i] >= 0 && reverseDiff[i] >= 0) {
                int min = nums[0];
                int max = nums[i+1];

                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        min = Math.min(nums[j], min);
                    }
                }

                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) {
                        max = Math.max(nums[j], max);
                    }
                }

                if (max > min && min < nums[i] && max < nums[i]) return true;
            }
        }

        return false;
    }
}
