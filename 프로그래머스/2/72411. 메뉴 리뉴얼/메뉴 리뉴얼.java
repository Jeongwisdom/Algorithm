import java.util.*;

class Solution {
    
    Map<Integer, Map<String, Integer>> comb;
    int max;
    
    public String[] solution(String[] orders, int[] course) {
        comb = new HashMap<>();
        for (int i = 0; i < course.length; i++) {
            comb.put(course[i], new HashMap<>());
            if (i == course.length - 1) max = course[i];
        }
        
        for (String s: orders) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            DFS(new String(c), 0, 0, new StringBuilder());
        }
        
        List<String> list = new ArrayList<>();
        for (Map<String, Integer> map: comb.values()) {
            List<Map.Entry<String, Integer>> sort = new ArrayList<>(map.entrySet());
            Collections.sort(sort, (e1, e2) -> e2.getValue() - e1.getValue());
            int count = 2;
            for (Map.Entry<String, Integer> entry: sort) {
                if (entry.getValue() >= count) {
                    list.add(entry.getKey());
                    count = entry.getValue();
                } else break;
            }
        }
        
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private void DFS(String s, int count, int id, StringBuilder order) {
        if (count > max) return;
        if (comb.containsKey(count)) {
            Map<String, Integer> map = comb.get(count);
            map.put(order.toString(), map.getOrDefault(order.toString(), 0) + 1);
        }
        for (int i = id; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(order);
            sb.append(s.charAt(i));
            DFS(s, count + 1, i + 1, sb);
        }
    }
}