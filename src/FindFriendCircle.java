import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1036/
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 *
 * 注意：
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 */

public class FindFriendCircle {
    public int findCircleNum(int[][] M) {
        boolean[] restGroup = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            restGroup[i] = true;
        }

        int groups = 0;
        for (int i = 0; i < M.length; i++) {
            if (restGroup[i]) {
                groups++;
                DFS(M, i, restGroup);
            }
        }

        return groups;
    }

    private void DFS(int[][]M, int line, boolean[] restGroup) {
        boolean notDone = restGroup[line];
        if (notDone) {
            restGroup[line] = false;
            for (int i = 0; i < M.length; i++) {
                if (M[line][i] == 1) {
                    M[i][line] = M[line][i] = 0;

                    if (line != i) {
                        DFS(M, i, restGroup);
                    }
                }
            }
        }
    }
}
