import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/237/learn-to-use-dict/989/
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 * 输入:"tree"
 * 输出:"eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 示例 2:
 * 输入:"cccaaa"
 * 输出:"cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 * 示例 3:
 * 输入:"Aabb"
 * 输出:"bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 */

public class FrequencySort {

    public String frequencySort(String s) {
        CharTimes[] ct = new CharTimes[128];
        for (int i = 0; i < ct.length; i++) {
            ct[i] = new CharTimes((char)0, 0);
        }
        for (Character ch : s.toCharArray()) {
            ct[ch].ch = ch;
            ct[ch].times++;
        }

        Arrays.sort(ct, new CharTimesComp());
        StringBuilder strBuilder = new StringBuilder();
        for (CharTimes charTime : ct) {
            if (charTime.ch == (char)0) break;
            for (int i = 0; i < charTime.times; i++) {
                strBuilder.append(charTime.ch);
            }
        }

        return strBuilder.toString();
    }

    class CharTimes {
        char ch;
        int times;
        CharTimes(char ch, int times) {
            this.ch = ch;
            this.times = times;
        }
    }

    class CharTimesComp implements Comparator<CharTimes> {

        @Override
        public int compare(CharTimes o1, CharTimes o2) {
            return o2.times - o1.times;
        }
    }
}
