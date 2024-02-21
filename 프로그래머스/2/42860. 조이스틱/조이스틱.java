import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int min = name.length() - 1;
        int ex = 0;
        char c;
        for (int i = 0; i < name.length(); i++) {
            c = name.charAt(i);
            if (c != 'A') {
                answer += Math.min(c - 'A', 'Z' - c + 1);
                min = Math.min(min, 2 * ex + name.length() - i);
                min = Math.min(min, 2 * (name.length() - i) + ex);
                ex = i;
            }
        }
        min = Math.min(min, ex);
        
        return answer + min;
    }
}