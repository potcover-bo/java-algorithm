package hot100.medium;

import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int curIndex = stack.pop();
                    res[curIndex] = i - curIndex;
                }
                stack.push(i);
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] temp = {30,40,90,60};
        int[] res = dailyTemperatures(temp);
        for (int n : res) {
            System.out.print(n + " ");
        }

    }
}
