package dp;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
 * 计算其二进制表示中 1 的个数 ，
 * 返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class CountBits {

    /**
     * i为奇数时候 比他前面的那一个偶数多了一个1  最后一位为1
     * i为偶数时候 和i / 2的一样多  就是多了后面一个0
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1;
            }else {
                res[i] = res[i / 2];
            }
        }

        return res;
    }
}
