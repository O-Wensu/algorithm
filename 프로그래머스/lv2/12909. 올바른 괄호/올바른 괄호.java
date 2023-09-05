import java.util.*;

class Solution {
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                stack.push('(');
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            return false;
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}