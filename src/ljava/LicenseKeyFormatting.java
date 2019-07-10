package ljava;



/**
 * 482. 密钥格式化
 * https://leetcode-cn.com/problems/license-key-formatting/
 *
 * 给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。
 * 给定一个数字 K，重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符，第一个分组
 * 至少要包含 1 个字符。两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 *
 * 示例 1：
 * 输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *      注意，两个额外的破折号需要删掉。
 *
 * 示例 2：
 * 输入：S = "2-5g-3-J", K = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 *  
 * 提示:
 * S 的长度不超过 12,000，K 为正整数
 * S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
 * S 非空
 *
 */

public class LicenseKeyFormatting {

    /**
     * 执行用时 :44 ms, 在所有 Java 提交中击败了48.18%的用户
     * 内存消耗 :45.3 MB, 在所有 Java 提交中击败了50.00%的用户
     */

    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.isEmpty()) return S;

        String string = S.replace("-", "").toUpperCase();
        if (string.isEmpty()) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int mod = string.length() % K;
        stringBuilder.append(string,0, mod);
        for (int i = mod; i < string.length(); i += K) {
            if (i != 0) stringBuilder.append("-");
            stringBuilder.append(string, i, i + K);
        }

        return stringBuilder.toString();
    }
}
