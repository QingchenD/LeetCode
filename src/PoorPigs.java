/**
 * 458. 可怜的小猪
 * https://leetcode-cn.com/problems/poor-pigs/
 *
 * 有 1000 只水桶，其中有且只有一桶装的含有毒药，其余装的都是水。它们从外观看起来都一样。如果小猪喝了毒药，它会在 15 分钟内死去。
 * 问题来了，如果需要你在一小时内，弄清楚哪只水桶含有毒药，你最少需要多少只猪？
 * 回答这个问题，并为下列的进阶问题编写一个通用算法。
 *
 * 进阶:
 * 假设有 n 只水桶，猪饮水中毒后会在 m 分钟内死亡，你需要多少猪（x）就能在 p 分钟内找出 “有毒” 水桶？
 * 这 n 只水桶里有且仅有一只有毒的桶。
 *
 * 提示：
 * 可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。
 * 小猪喝完水后，必须有 m 分钟的冷却时间。在这段时间里，只允许观察，而不允许继续饮水。
 * 任何给定的桶都可以无限次采样（无限数量的猪）。
 *
 */

public class PoorPigs {
    /**
     *  算法：
     *     本题的思路是使用N进制， N则是使用的猪的头数。
     *
     * 一只猪可以测试的次数为minutesToTest/minusToDie,每次测试可同时饮用任意数量的水桶；
     * 假设有一小时，15分钟内死去，5个桶，则1只小猪即可；
     * 假设有25个桶，1小时，15分钟死去
     * -	-	-	-	-
     * 1	2	3	4	5
     * 6	7	8	9	10
     * 11	12	13	14	15
     * 16	17	18	19	20
     * 21	22	23	24	25
     * 第1只猪喝每一行所有编号的水桶的混合水，第2只猪喝每一列所有编号的水桶的混合水，
     * 如果第一只毒死在第0行，第二只没有死，则有毒的水是第5桶， 所以25个桶，只需2只小猪。
     * 同理，3只小猪，则可以测 5 * 5 * 5 = 125只桶，以此类推。
     *
     *
     * 执行用时 :1 ms, 在所有 Java 提交中击败了39.13%的用户
     * 内存消耗 :34.1 MB, 在所有 Java 提交中击败了50.00%的用户
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int repeat = minutesToTest / minutesToDie;
        return (int)Math.ceil(Math.log(buckets) / Math.log(repeat + 1));
    }


    /**
     * 算法：
     *   习惯采用二进制
     *
     * 1000个桶， 15分钟，60分钟测试时间：算的需要8只小猪
     */
    public int poorPigs1(int buckets, int minutesToDie, int minutesToTest) {
        int repeat = minutesToTest / minutesToDie;
        int oneTimeBuckets = buckets / repeat;
        int pigs = (int)(Math.log(oneTimeBuckets) / Math.log(2));
        return Math.pow(2, pigs) * repeat >= buckets ? pigs : pigs + 1;
    }
}
