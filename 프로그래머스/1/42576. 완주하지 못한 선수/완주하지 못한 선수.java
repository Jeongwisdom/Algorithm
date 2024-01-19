import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            if (map.get(s) == 1) map.remove(s);
            else map.put(s, map.get(s) - 1);
        }
        
        return map.keySet().iterator().next();
    }
}