package ljava;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1086. 前五科的均分
 * https://leetcode-cn.com/contest/biweekly-contest-2/problems/high-five/
 *
 * 给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
 * 对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
 *
 * 示例：
 * 输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * 输出：[[1,87],[2,88]]
 * 解释：
 * id = 1 的学生平均分为 87。
 * id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
 *
 * 提示：
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * 学生的 ID 在 1 到 1000 之间
 * 学生的分数在 1 到 100 之间
 * 每个学生至少有五个分数
 */

public class HighFive {

    /**
     *  只扫描一遍，就能算出总5门课的分数。
     *  空间复杂度: O(n) + 1000;
     *
     *  leetCoode : 6ms 超过91.67%的用户，速度提高一倍
     */

    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>>  map = new HashMap<>();
        int[] sum = new int[1001]; //学生ID为index;
        for (int[] score : items) {
            Queue<Integer> queue = map.get(score[0]);
            sum[score[0]] += score[1];
            if (queue == null) {
                queue = new PriorityQueue<>(5);
                queue.add(score[1]);
                map.put(score[0], queue);
            } else {
                queue.add(score[1]);
                if (queue.size() > 5) {
                    sum[score[0]] -= queue.poll();
                }
            }
        }

        int size = map.size();
        int[][] rst = new int[size][2];
        int index = 0;
        for (Integer id : map.keySet()) {
            rst[index][0] = id;
            rst[index][1] = sum[id] / 5;
            index++;
        }

        return rst;
    }


    /**
     *  需要访问两边数据组：一次统计，一次求平均数：
     *  空间复杂度： O(n)
     *  leetcode ： 14ms  超过64.58%的用户
     *
     */
    public int[][] highFive1(int[][] items) {
        Map<Integer, Queue<Integer>>  map = new HashMap<>();

        for (int[] score : items) {
            Queue<Integer> queue = map.get(score[0]);
            if (queue == null) {
                queue = new PriorityQueue<>(5);
                queue.add(score[1]);
                map.put(score[0], queue);
            } else {
                queue.add(score[1]);
                if (queue.size() > 5) {
                    queue.poll();
                }
            }
        }

        int size = map.size();
        int[][] rst = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            rst[index][0] = entry.getKey();
            Queue<Integer> q = entry.getValue();
            int sum = 0;
            while (q.size() > 0) {
                sum += q.poll();
            }
            rst[index][1] = sum / 5;
            index++;
        }

        return rst;
    }
}
