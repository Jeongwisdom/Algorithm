import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        String str;
        
        for (int i = 0; i < cities.length; i++) {
            str = cities[i].toUpperCase();
            if (list.contains(str)) {
                answer += 1;
                list.remove(str);
            } else answer += 5;
            list.add(str);
            if (list.size() > cacheSize) list.remove(0);
        }
        
        return answer;
    }
}