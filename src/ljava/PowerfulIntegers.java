package ljava;

import java.util.*;

/**
 * https://leetcode-cn.com/contest/weekly-contest-118/problems/powerful-integers/
 *
 * 给定两个非负整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 *
 * 示例 1：
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 *
 * 示例 2：
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 *
 * 提示：
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 *
 */

public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        long powerX , powerY;
        int sum;
        for (int i = 0; i < 31; i++) {
            powerX = (long)Math.pow(x, i);
            if (powerX > bound) break;

            for (int j = 0; j < 31; j++) {
                powerY = (long)Math.pow(y,j);
                sum = (int)(powerX + powerY);
                if (powerY > bound || sum > bound) break;
                set.add(sum);
            }
        }

        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }
}