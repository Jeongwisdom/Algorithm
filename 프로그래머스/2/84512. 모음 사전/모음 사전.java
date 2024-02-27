import java.util.*;

class Solution {
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        char[] c = {'A', 'E', 'I', 'O', 'U'};
        for (int i = 0; i < c.length; i++) {
            map.put(c[i], i);
        }
        
        int answer = 0;
        while (true) {
            if (sb.length() < 5) {
                sb.append('A');
            } else {
                while (sb.charAt(sb.length() - 1) == 'U') {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.setCharAt(sb.length() - 1, c[map.get(sb.charAt(sb.length() - 1)) + 1]);
            }
            
            answer++;
            if (sb.toString().equals(word)) return answer;
        }
    }
}