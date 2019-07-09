package ljava;

/**
 * 把n骰子扔在地上，所有骰子朝上一面的点数之和为s, 求所有可能的值，出现的次数。
 */

public class DiceDotCount {

    private int[] result;
    public int[] diceDotCount(int n) {
        if (n <= 0) return null;

        result = new int[6 * n + 1];
        //subDiceDotCount(n, 0);
        subDiceDootCount(n);
        return result;
    }

    private void subDiceDotCount(int n, int sum) {
        if (n == 0) {
            result[sum]++;
            return;
        }

        for (int i = 1; i <= 6; i++) {
            subDiceDotCount(n - 1, sum + i);
        }
    }

    private void subDiceDootCount(int n) {
        for (int i = 1 ; i <= 6 ; i++) {
            result[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= j && k <= 6; k++) {
                    result[j] += result[j - k];
                }
            }
        }
    }
}
