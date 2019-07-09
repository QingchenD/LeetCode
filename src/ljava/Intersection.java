package ljava;

import java.util.*;

/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/236/learn-to-use-set/977/
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 */

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        set1.retainAll(set2);

        int[] result = new int[set1.size()];
        Iterator<Integer> it = set1.iterator();
        for (int i = 0; i < result.length; i++) {
            result[i] = it.next();
        }
        return result;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int value = 0;

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j])  {
                if (list.size() == 0) {
                    value = nums1[i];
                    list.add(nums1[i]);
                } else if (value != nums1[i]) {
                    list.add(nums1[i]);
                    value = nums1[i];
                }
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) i++;
            else j++;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
//        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j])  { set.add(nums1[i]); i++; j++; }
            else if (nums1[i] < nums2[j]) i++;
            else j++;
        }

        int[] result = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        for (int i = 0; i < result.length; i++) {
            result[i] = it.next();
        }
        return result;
    }
}
