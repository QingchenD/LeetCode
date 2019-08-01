package mykotlin

class ZumaGame {

    /**
     * 执行用时 :280 ms, 在所有 Kotlin 提交中击败了100.00%的用户
     * 内存消耗 :33.1 MB, 在所有 Kotlin 提交中击败了100.00%的用户
     */
    private val MAXCOUNT = 6
    fun findMinStep(board: String, hand: String): Int {
        val handCount = IntArray(26)
        for (ch in hand) {
           handCount[ch - 'A']++
        }

        val result = backtrack("$board#", handCount)
        return if (result == MAXCOUNT) -1 else result
    }

    private fun backtrack(s: String, h: IntArray): Int {
        val str = removeConsecutive(s)
        if (str == "#") return 0
        var rs = MAXCOUNT
        var need = 0
        var i = 0
        for (j in str.indices) {
            if (str[j] == str[i]) continue
            need = 3 - (j - i)
            if (h[str[i] - 'A'] >= need) {
                h[str[i] - 'A'] -= need
                rs = Math.min(rs, need + backtrack(str.substring(0, i) + str.substring(j), h))
                h[str[i] - 'A'] += need
            }
            i = j
        }
        return rs;

    }

    private fun removeConsecutive(board: String): String {
        var i = 0
        for (j in board.indices) {
            if (board[j] == board[i]) {
                continue
            }
            if (j - i >= 3) {
                return removeConsecutive(board.substring(0, i) + board.substring(j))
            } else {
                i = j
            }
        }
        return board
    }
}