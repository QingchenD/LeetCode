import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 */

public class GenerateYanghui {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list ;

        for (int i = 1; i <= numRows; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j== i - 1) {
                    list.add(1);
                } else {
                    List<Integer> preRowList = result.get(i - 2);
                    list.add(preRowList.get(j -1) + preRowList.get(j));
                }
            }
            result.add(list);
        }

        return result;
    }
}
