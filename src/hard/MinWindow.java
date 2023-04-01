package hard;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {


        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();

        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;

        // 窗口中有多少个字符和t中出现次数相等
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);

            // 扩大窗口
            right++;
            // 进行窗口更新
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // c字符在t和窗口中出现次数一样
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            // t中所有字符出现次数和当前窗口一样
            while (valid == needs.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d是需要移除窗口的字符
                char d = s.charAt(left);
                left++;

                //进行窗口的更新
                if (needs.containsKey(d)) {
                    //减小窗口后 满足条件的字符需要减1
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
