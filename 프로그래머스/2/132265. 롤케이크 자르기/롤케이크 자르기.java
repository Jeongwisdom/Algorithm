import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: topping) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int i: topping) {
            set.add(i);
            int sum = map.get(i) - 1;
            if (sum == 0) map.remove(i);
            else map.put(i, sum);
            if (set.size() == map.size()) answer++;
            else if (set.size() > map.size()) break;
        }
        
        return answer;
    }
}