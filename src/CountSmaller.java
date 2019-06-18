import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/145/
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质：
 * counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 示例:
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 *
 */

public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        if (nums.length == 0) return res;

        for (int i = nums.length - 1; i >= 0 ; i--) {
            res.addFirst(binaryInsert(nums, i));
        }

        return res;
    }

    private int binaryInsert(int[] numbs, int i) {
        if (i == numbs.length - 1) return 0;

        int lo = i + 1;
        int hi = numbs.length - 1;
        int mid = lo ;
        while (lo < hi) {
            mid = lo + ((hi - lo) >> 2);
            if (numbs[mid] <= numbs[i]) hi = mid - 1;
            else lo = mid + 1;
        }

        int tmp = numbs[i];
        while (mid < numbs.length && numbs[mid] == numbs[i]) mid++;
        if (mid == numbs.length) {
            System.arraycopy(numbs, i + 1, numbs, i, mid - (i + 1));
            numbs[mid - 1] = tmp;
            return 0;
        } else if (numbs[mid] < numbs[i]) {
            System.arraycopy(numbs, i + 1, numbs, i, (mid - 1) - (i + 1) + 1);
            numbs[mid - 1] = tmp;
            return numbs.length - 1 - (mid - 1);
        } else {
            System.arraycopy(numbs, i + 1, numbs, i, mid + 1 - (i + 1));
            numbs[mid] = tmp;
            return (numbs.length - 1) - (mid);
        }
    }

    // very slowly
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums.length == 0) return res;

        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) count++;
            }

            res.add(count);
        }

        return res;
    }
}
