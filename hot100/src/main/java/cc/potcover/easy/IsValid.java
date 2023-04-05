package cc.potcover.easy;

import java.util.Stack;

public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char val = stack.pop();
                if (c == ')' && val != '(') {
                    return false;
                }
                if (c == ']' && val != '[') {
                    return false;
                }
                if (c == '}' && val != '{') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
