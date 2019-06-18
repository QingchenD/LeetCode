/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1013/
 *
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 * 例如，
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * 边界情况:
 *
 * 你是否考虑了 路径 = "/../" 的情况？
 * 在这种情况下，你需返回 "/" 。
 * 此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
 * 在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 *
 */

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        for (int i = 0 ; i < s.length; i++) {
            if (s[i].equals("..")) {
                s[i] = "";
                int j = i - 1;
                while (j >= 0) {
                    if (!s[j].equals("")) {
                        s[j] = "";
                        break;
                    } else {
                        j--;
                    }
                }
            } else if (s[i].equals(".")){
                s[i] = "";
            }
        }

        StringBuilder resultPath = new StringBuilder();
        for (int i = 0 ; i < s.length; i++) {
            if (!s[i].equals("")) {
                resultPath.append("/");
                resultPath.append(s[i]);
            }
        }

        if (resultPath.length() == 0) resultPath.append("/");

        return resultPath.toString();
    }
}
