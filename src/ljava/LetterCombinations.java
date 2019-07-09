package ljava;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].*
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

public class LetterCombinations {
    private HashMap<Character,String> lettersMap = createLetterMap();
    private static HashMap<Character,String> createLetterMap() {
        HashMap<Character,String> map = new HashMap<>();
        map.put('1',"");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv" );
        map.put('9', "wxyz");

        return map;
    }
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();

        if (digits.isEmpty())
            return res;
        res.add("");

        while (res.peek().length() != digits.length()) {
            String temp = res.pop();
            String value = lettersMap.get(digits.charAt(temp.length()));
            for (char c : value.toCharArray())
                res.add(temp + c);
        }

        return res;
    }
}
