package ljava;

import java.util.ArrayList;
import java.util.List;

/**
 *  488. 祖玛游戏
 *  https://leetcode-cn.com/problems/zuma-game/
 *
 * 回忆一下祖玛游戏。现在桌上有一串球，颜色有红色(R)，黄色(Y)，蓝色(B)，绿色(G)，还有白色(W)。 现在你手里也有几个球。
 * 每一次，你可以从手里的球选一个，然后把这个球插入到一串球中的某个位置上（包括最左端，最右端）。接着，如果有出现三个或者三个以上颜色相同的球相连的话，就把它们移除掉。重复这一步骤直到桌上所有的球都被移除。
 * 找到插入并可以移除掉桌上所有球所需的最少的球数。如果不能移除桌上所有的球，输出 -1 。
 *
 * 示例:
 * 输入: "WRRBBW", "RB"
 * 输出: -1
 * 解释: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW （翻译者标注：手上球已经用完，桌上还剩两个球无法消除，返回-1）
 *
 * 输入: "WWRRBBWW", "WRBRW"
 * 输出: 2
 * 解释: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 *
 * 输入:"G", "GGGGG"
 * 输出: 2
 * 解释: G -> G[G] -> GG[G] -> empty
 *
 * 输入: "RBYYBBRRB", "YRBGB"
 * 输出: 3
 * 解释: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
 *
 * 标注:
 * 1. 你可以假设桌上一开始的球中，不会有三个及三个以上颜色相同且连着的球。
 * 2. 桌上的球不会超过20个，输入的数据中代表这些球的字符串的名字是 "board" 。
 * 3. 你手中的球不会超过5个，输入的数据中代表这些球的字符串的名字是 "hand"。
 * 4. 输入的两个字符串均为非空字符串，且只包含字符 'R','Y','B','G','W'。
 *
 */
public class ZumaGame {

    private int MAX_COUNT = 6;
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (int i = 0; i < hand.length(); i++) {
            handCount[hand.charAt(i) - 'A']++;
        }

        List<BoardNode> boardCount = new ArrayList<>();
        int j = 0;
        int count = 0;
        for (int i = 0; i <= board.length(); i++) {
            if (i < board.length() && board.charAt(i) == board.charAt(j)) {
                count ++;
                continue;
            }
            boardCount.add(new BoardNode(board.charAt(j), count));
            count = 1;
            j = i;
        }

        int rst = removeBalls(boardCount, handCount, -1);
        return rst == MAX_COUNT ? -1 : rst;
    }

    private int removeBalls(List<BoardNode> boardCount, int[] handCount, int maybeRemove) {
        //---------------------------------------------------------------debug
        StringBuilder sBuilder = new StringBuilder();
        for (BoardNode n : boardCount) {
            for (int k = 0; k < n.count; k++) {
                sBuilder.append(n.ch);
            }
        }
        StringBuilder handSB = new StringBuilder();
        for (int k = 0; k < handCount.length; k++) {
            int c = handCount[k];
            for (int x = 0; x < c; x++) {
                handSB.append(((char)(k + 'A')));
            }
        }
        System.out.println("s: " + sBuilder.toString() + " hand:" + handSB.toString());
        //----------------------------------------------------------------------------debug
        if (maybeRemove > -1) {
            removeCon(boardCount, maybeRemove);
        }
        if (boardCount.size() == 0) return 0;

        int res = MAX_COUNT;
        for (int i = 0; i < boardCount.size(); i++) {
            BoardNode boardNode = boardCount.get(i);
            int need = 3 - boardNode.count;
            if (need <= handCount[boardNode.ch - 'A']) {
                List<BoardNode> tmp = new ArrayList<>(boardCount);
                tmp.remove(i);
                handCount[boardNode.ch - 'A'] -= need;
                //---------------------------------------------------------debug
                StringBuilder strBuilder = new StringBuilder();
                for (BoardNode n : tmp) {
                    for (int k = 0; k < n.count; k++) {
                        strBuilder.append(n.ch);
                    }
                }

                StringBuilder hSB = new StringBuilder();
                for (int k = 0; k < handCount.length; k++) {
                    int c = handCount[k];
                    for (int x = 0; x < c; x++) {
                        hSB.append(((char)(k + 'A')));
                    }
                }
                System.out.println(strBuilder.toString() + " hand:" + hSB.toString() + " need:" + need + " ch:" + boardNode.ch);
                //--------------------------------------------------------------debug

                res = Math.min(need + removeBalls(tmp, handCount, i - 1), res);
                System.out.println(" roll  back ******************");
                handCount[boardNode.ch - 'A'] += need;
            }
        }

        return res;
    }

    private void removeCon(List<BoardNode> boardCount, int i) {
        if (i >= 0 && i + 1 < boardCount.size()) {
            BoardNode n1 = boardCount.get(i);
            BoardNode n2 = boardCount.get(i + 1);
            if (n1.ch == n2.ch && n1.count + n2.count >= 3) {
                boardCount.remove(i + 1);
                boardCount.remove(i);
                removeCon(boardCount, i - 1);
            }
        }
    }

    class BoardNode {
        char ch;
        int count;
        BoardNode(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }




    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了87.50%的用户
     * 内存消耗 :35.2 MB, 在所有 Java 提交中击败了90.00%的用户
     */
    private int MAXCOUNT = 6;  // the max balls you need will not exceed 6 since "The number of balls in your hand won't exceed 5"
    public int findMinStep1(String board, String hand) {
        int[] handCount = new int[26];
        for (int i = 0; i < hand.length(); i++) {
            handCount[hand.charAt(i) - 'A']++;
        }
        int result = backtrack(board + "#", handCount);  // append a "#" to avoid special process while j==board.length, make the code shorter.
        return result == MAXCOUNT ? -1 : result;
    }

    private int backtrack(String s, int[] h) {
        s = removeConsecutive(s);
        if (s.equals("#")) return 0;
        int rs = MAXCOUNT, need = 0;
        int i = 0;
        for (int j = 0 ; j < s.length(); ++j) {
            if (s.charAt(j) == s.charAt(i)) continue;
            need = 3 - (j - i);     //balls need to remove current consecutive balls.
            if (h[s.charAt(i) - 'A'] >= need) {
                h[s.charAt(i) - 'A'] -= need;
                rs = Math.min(rs, need + backtrack(s.substring(0, i) + s.substring(j), h));
                h[s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        return rs;
    }

    //remove consecutive balls longer than 3
    private String removeConsecutive(String board) {
        int i = 0;
        for (int j = 0; j < board.length(); ++j) {
            if (board.charAt(j) == board.charAt(i)) continue;
            if (j - i >= 3)
                return removeConsecutive(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        return board;
    }
}
