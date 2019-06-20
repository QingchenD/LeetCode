/**
 * 338. 比特位计数
 * https://leetcode-cn.com/problems/counting-bits/
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 *
 *  示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 */


public class CountBits {

    public int[] countBits(int num) {
        int[] rst = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            if((i & 1) == 1) rst[i] = rst[i-1] + 1;
            else rst[i] = rst[i>>1];
        }
        return rst;
    }

    public int[] countBits2(int num) {
        int[] rst = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            if( i % 2 == 1) rst[i] = rst[i-1] + 1;
            else rst[i] = rst[i / 2];
        }
        return rst;
    }

    private int[] bitsDic = new int[] {   //  length = 256
                  //0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
                    0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4,
                    1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
                    1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
                    2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                    1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
                    2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                    2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                    3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
                    1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
                    2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                    2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                    3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
                    2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                    3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
                    3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
                    4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8 };

    /**
     * 使用生成的表， 但是速度依然不够快
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        //int[] bitsDic = new int[256];
        //buildBitsDictionary(bitsDic);

        int[] rst = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            rst[i] = bitsDic[i & 0xFF] + bitsDic[(i >> 8) & 0xFF] +
                    bitsDic[(i >> 16) & 0xFF] +  bitsDic[(i >> 24) & 0xFF];
        }

        return rst;
    }

    /**
     * 生成bits表
     * @param dic
     */
    private void buildBitsDictionary(int[] dic) {
        int n, bits;
        for (int i = 0; i < dic.length; i++) {
            n = i;
            bits = 0;
            while (n > 0) {
                bits++;
                n &= n - 1;
            }
            dic[i] = bits;
        }
    }
}
