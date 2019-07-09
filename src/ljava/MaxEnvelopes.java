package ljava;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1031/
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 */

public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        Envelope[] es = new Envelope[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            es[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
        }
        Arrays.sort(es, new EnvelopeComparator());

        int[] ends = new int[es.length];
        ends[0] = es[0].height;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < es.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (es[i].height > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = es[i].height;
        }
        return right + 1;
    }

    class Envelope {
        int width;
        int height;
        Envelope(int width, int height){
            this.width = width;
            this.height = height;
        }
    }

    class EnvelopeComparator implements Comparator<Envelope> {

        @Override
        public int compare(Envelope o1, Envelope o2) {
            if (o1.width != o2.width) {
                return o1.width - o2.width;
            } else {
                return o2.height - o1.height;
            }
        }
    }
}
