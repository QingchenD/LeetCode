package mykotlin

class TribonacciKT {
    fun tribonacci(n: Int): Int {
        if (n < 2) return n
        if (n == 2) return 1

        var t0 = 0
        var t1 = 1
        var t2 = 1
        for (i in 3..n) {
            val tmp = t2
            t2 += t0 + t1
            t0 = t1
            t1 = tmp
        }
        return t2
    }
}