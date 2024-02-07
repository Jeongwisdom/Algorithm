import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int answer = -1;
        char end = words[0].charAt(0);
        
        for (int i = 0; i < words.length; i++) {
            if (end != words[i].charAt(0) || map.getOrDefault(words[i], 0) != 0) {
                answer = i;
                break;
            } else map.put(words[i], 1);
            end = words[i].charAt(words[i].length() - 1);
        }

        return answer == -1? new int[] {0, 0}: new int[] {answer % n + 1, answer / n + 1};
    }
}