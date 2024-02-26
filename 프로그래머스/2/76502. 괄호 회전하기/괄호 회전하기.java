import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() % 2 == 1) return 0;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i))
                .append(s.substring(0, i));
            int ch = check(sb.toString());
            if (ch == -1) answer++;
            else i += ch;
        }
        
        return answer;
    }
    
    public int check(String s) {
        Stack<Character> stack = new Stack<>();
        char[] open = {'(', '[', '{'};
        char[] close = {')', ']', '}'};
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < open.length; j++) {
                if (s.charAt(i) == open[j]) {
                    stack.push(s.charAt(i));
                    continue;
                }
            }
            if (stack.isEmpty()) return i;
            for (int j = 0; j < close.length; j++) {
                if (s.charAt(i) == close[j]) {
                    if (stack.peek() == open[j]) {
                        stack.pop();
                        continue;
                    } else return i;
                }
            }
        }
        
        return -1;
    }
}