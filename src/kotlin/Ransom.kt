package mykotlin

//class Ransom {
//    fun canConstruct(ransomNote: String, magazine: String): Boolean {
//        if (ransomNote.isEmpty()) return true
//        else if (magazine.isEmpty()) return false
//
//        val count = IntArray(26)
//        for (ch: Char in ransomNote) {
//            count[ch - 'a']++
//        }
//
//        for (ch: Char in magazine) {
//            count[ch - 'a']--;
//        }
//
//        for (i in count) {
//            if (i > 0) return false
//        }
//
//        return true
//    }
//}

class Ransom {

    /**
     * 执行用时 :324 ms, 在所有 Kotlin 提交中击败了100.00%的用户
     * 内存消耗 :43.2 MB, 在所有 Kotlin 提交中击败了100.00%的用户
     */
    fun canConstruct(ransomNote: String?, magazine: String?): Boolean {
        if (ransomNote == null || ransomNote.isEmpty()) return true
        else if (magazine == null || magazine.isEmpty()) return false

        val count = IntArray(26)
        for (ch in ransomNote.toCharArray()) {
            count[ch - 'a']++
        }

        for (ch in magazine.toCharArray()) {
            count[ch - 'a']--
        }

        for (i in count) {
            if (i > 0) return false
        }
        return true
    }
}