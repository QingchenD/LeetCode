import java.util.*;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1046/
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */

public class MergeRange {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        for (int i = 1; i < intervals.size(); ) {
            Interval current = intervals.get(i);
            Interval pre = intervals.get(i - 1);

            if (current.start <= pre.end) {
                if (pre.end < current.end) {
                    pre.end = current.end;
                }
                intervals.remove(i);
            } else {
                i++;
            }
        }

        return intervals;
    }

    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
