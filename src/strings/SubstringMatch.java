package strings;

/**
 * 子串查找
 */
public class SubstringMatch {

    private SubstringMatch(){}

    /**
     * 暴力搜索
     * @param s
     * @param t
     * @return
     */
    public static int bruteforce(String s, String t) {
        if (s.length() < t.length()) {
            return -1;
        }

        // 剩余长度小于t的长度
        for (int i = 0; i + t.length() <= s.length(); i++) {
            int j = 0;
            for (; j < t.length(); j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    break;
                }
            }
            if (j == t.length()) {
                return i;
            }
        }

        return -1;
    }
}
