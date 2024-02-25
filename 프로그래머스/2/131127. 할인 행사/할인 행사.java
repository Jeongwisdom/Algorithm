import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0; 
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
            count += number[i];
        }
        
        int answer = 0;
        for (int i = 0, j = 0; i < discount.length; i++) {
            if (map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) - 1);
                if (map.get(discount[i]) >= 0) count--;
            }
            
            if (i >= 10) {
                if (map.containsKey(discount[j])) {
                    map.put(discount[j], map.get(discount[j]) + 1);
                    if (map.get(discount[j]) > 0) count++;
                }
                j++;
            }
            
            if (count == 0) answer++;
        }
        
        return answer;
    }
}