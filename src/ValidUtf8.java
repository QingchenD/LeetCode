/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/247/bonus/1037/
 *
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
 *
 * 这是 UTF-8 编码的工作方式：
 * Char. number range  |        UTF-8 octet sequence
 * (hexadecimal)    |              (binary)
 * --------------------+---------------------------------------------
 * 0000 0000-0000 007F | 0xxxxxxx
 * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 *
 * 注意:
 * 输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *
 * 示例 1:
 * data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
 * 返回 true 。
 * 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
 *
 * 示例 2:
 * data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
 * 返回 false 。
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 *
 */
public class ValidUtf8 {

    private final int FOUR_BYTE_HEAD  = 0x1E << 3;   // 11110 << 3
    private int FOUR_BYTE_HEAD_MASK   = 0xF8 ;

    private final int THREE_BYTE_HEAD = 0xE << 4;    // 1110 << 4
    private int THREE_BYTE_HEAD_MASK  = 0xF0;

    private final int TWO_BYTE_HEAD   = 0x6 << 5;    // 110 << 5
    private int TWO_BYTE_HEAD_MASK    = 0xE0;

    private final int ONE_BYTE_HEAD   = 0x0 ;        // 0xxxxx
    private int ONE_BYTE_HEAD_MASK    = 0x80;

    private final int SUB_HEAD        = 0x2 << 6;    // 10
    private int SUB_HEAD_MASK         = 0xC0;


    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return false;
        int count = 0;
        for (int i = 0; i < data.length ; i++) {
            int head = data[i];
            if ( (head & FOUR_BYTE_HEAD_MASK) == FOUR_BYTE_HEAD) {
                if (count > 0) return false;
                count = 3;
            } else if ((head & THREE_BYTE_HEAD_MASK) == THREE_BYTE_HEAD) {
                if (count > 0) return false;
                count = 2;
            } else if ((head & TWO_BYTE_HEAD_MASK) == TWO_BYTE_HEAD) {
                if (count > 0) return false;
                count = 1;
            } else if ((head & ONE_BYTE_HEAD_MASK) == ONE_BYTE_HEAD) {
                if (count > 0) return false;
                count = 0;
            } else if ((head & SUB_HEAD_MASK) == SUB_HEAD) {
                if (count > 0) {
                    count --;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return count == 0;
    }
}
