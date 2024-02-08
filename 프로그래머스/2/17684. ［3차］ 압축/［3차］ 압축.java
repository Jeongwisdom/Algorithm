import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), c - 'A' + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        String str = "";
        int k = 1;
        for (int i = 0; i < msg.length(); i += k) {
            for (int j = msg.length(); j >= i + 1; j--) {
                str = msg.substring(i, j);
                if (map.containsKey(str)) {
                    k = j - i;
                    break;
                }
            }
            list.add(map.get(str));
            if (i + str.length() < msg.length()) map.put(msg.substring(i, i + str.length() + 1) , map.size() + 1);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}