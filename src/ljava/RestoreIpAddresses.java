package ljava;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1044/
 *
 *  输入: "25525511135"
 *  输出: ["255.255.11.135", "255.255.111.35"]
 */

public class RestoreIpAddresses {
    private List<String> ipResult = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return ipResult;

        buildIpAddress(s, 0,0,"" );

        return ipResult;
    }

    private void buildIpAddress(String s, int start, int slices, String ip) {
        if (s.length() == start && slices == 4) {
            ipResult.add(ip);
        } else if (slices < 4 && start < s.length()) {
            for (int i = 1; i <= 3; i++) {
                if (s.charAt(start) == '0' && i > 1) break;

                if (start + i <= s.length()) {
                    String subStr = s.substring(start, start + i);
                    if (Integer.valueOf(subStr) <= 255) {
                        StringBuilder tmpIp = new StringBuilder(ip);
                        if (tmpIp.length() > 0) tmpIp.append(".");
                        buildIpAddress(s, start + i, slices + 1, tmpIp.append(subStr).toString());
                    }
                }
            }
        }
    }
}
