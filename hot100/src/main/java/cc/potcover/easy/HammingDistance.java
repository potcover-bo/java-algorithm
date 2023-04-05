package cc.potcover.easy;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 *
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int result = 0;
        while (res > 0) {
            if (res % 2 == 1) {
                result++;
            }

            res /= 2;
        }

        return result;
    }
}
