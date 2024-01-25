import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> name = new HashMap<>();
        Map<Integer, String> idx = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            name.put(players[i], i);
            idx.put(i, players[i]);
        }
        
        for (String calling: callings) {
            int id = name.get(calling);
            String tmp = idx.get(id - 1);
            idx.put(id - 1, calling);
            idx.put(id, tmp);
            name.put(calling, id - 1);
            name.put(tmp, id);
        }
        
        String[] answer = new String[idx.size()];
        for (int i = 0; i < idx.size(); i++) {
            answer[i] = idx.get(i);
        }
        
        return answer;
    }
}