import java.util.*;

class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder answer = new StringBuilder();
        for (char c: chars) {
            answer.append(c);
        }
        return answer.reverse().toString();
    }
}