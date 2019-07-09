package ljava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 *
 */

public class CombinationSum2 {


    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了97.18%的用户
     * 内存消耗 :38.4 MB, 在所有 Java 提交中击败了83.55%的用户
     *
     * 算法：
     *   回溯的时候，设置回溯的值，同样的值，不在计算，解决判重的问题。
     *
     * 从原始代码，到现在的第三版，代码效率提高了有15倍！！！（参考了其他大神的代码），仍需努力
     */
    List<List<Integer>> rst = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) return null;

        boolean[] flags = new boolean[candidates.length];
        Arrays.sort(candidates);
        recursionSum(candidates,0 , flags, target);
        return rst;
    }

    private void recursionSum(int[] candidates, int index, boolean[] flags, int target) {
        if (0 == target) {
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < flags.length; i++) {
                if (flags[i]) l.add(candidates[i]);
            }
            rst.add(l);
            return;
        }

        int pre = -1;
        for(int i = index; i < candidates.length && candidates[i] <= target; i++){
            if(candidates[i] != pre){
                flags[i] = true;
                recursionSum(candidates, i + 1, flags, target - candidates[i] );

                //这两句是递归和判重的精髓
                flags[i] = false;
                pre = candidates[i];
            }
        }
    }



    /**
     * 执行用时 :36 ms, 在所有 Java 提交中击败了20.96%的用户
     * 内存消耗 :38.5 MB, 在所有 Java 提交中击败了82.91%的用户
     *
     * 使用数组，替换List，减少一半的时间。
     */
/*
    List<List<Integer>> rst = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) return null;

        boolean[] flags = new boolean[candidates.length];
        Arrays.sort(candidates);
        recursionSum(candidates,0 , flags, target);
        return rst;
    }

    private void recursionSum(int[] candidates, int index, boolean[] flags, int target) {
        if (0 == target) {
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < flags.length; i++) {
                if (flags[i]) l.add(candidates[i]);
            }
            if (!isDuplicate(l)) {
                rst.add(l);
            }
            return;
        }
        if (target < 0 || index >= candidates.length) return;

        flags[index] = true;
        recursionSum(candidates, index + 1, flags, target - candidates[index] );

        flags[index] = false;
        recursionSum(candidates, index + 1, flags, target);

    }

    private boolean isDuplicate(List<Integer> list) {
        if (!rst.isEmpty()) {
            for (List<Integer> l : rst) {
                if (list.equals(l)) return true;
            }
        }
        return false;
    }
    */


    /**
     * 执行用时 :87 ms, 在所有 Java 提交中击败了9.05%的用户
     * 内存消耗 :50.3 MB, 在所有 Java 提交中击败了11.42%的用户
     */

    /*
    List<List<Integer>> rst = new ArrayList<>();
    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        if (candidates == null) return null;

        Arrays.sort(candidates);
        recursionSum(candidates,0 , new LinkedList<>(), target);
        return rst;
    }

    private void recursionSum(int[] candidates, int index, LinkedList<Integer> list, int target) {
        if (0 == target) {
            List<Integer> l = new ArrayList<>();
            l.addAll(list);
            if (!isDuplicate(l)) {
                rst.add(l);
            }
            return;
        }
        if (target < 0 || index >= candidates.length) return;

        list.add(candidates[index]);
        recursionSum(candidates, index + 1, list, target - candidates[index] );

        if (list.size() > 0) {
            list.removeLast();
            recursionSum(candidates, index + 1, list, target);
        }
    }

    private boolean isDuplicate(List<Integer> list) {
        if (!rst.isEmpty()) {
            for (List<Integer> l : rst) {
                if (list.equals(l)) return true;
            }
        }
        return false;
    }
    */
}
