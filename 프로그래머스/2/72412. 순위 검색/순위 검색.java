import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        for (String str: info) {
            DFS(str.split(" "), new StringBuilder(), 0);
        }
        for (List<Integer> list: map.values()) {
            Collections.sort(list);
        }
        
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" ");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < split.length - 1; j += 2) {
                sb.append(split[j]);
            }
            List<Integer> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            int score = Integer.parseInt(split[7]);
            int id = list.size();
            if (list.size() > 0 && list.get(list.size() - 1) >= score)  {
                int left = 0;
                int right = list.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= score) right = mid - 1;
                    else if (list.get(mid) < score) left = mid + 1;
                }
                id = right + 1;
            }
            answer[i] = list.size() - id;
        }
        
        return answer;
    }
    
    public void DFS(String[] split, StringBuilder ex, int count) {
        if (count == split.length - 1) {
            map.putIfAbsent(ex.toString(), new ArrayList<>());
            List<Integer> list = map.get(ex.toString());
            list.add(Integer.parseInt(split[4]));
        } else {
            StringBuilder sb = new StringBuilder(ex.toString());
            sb.append(split[count]);
            DFS(split, sb, count + 1);
            sb = new StringBuilder(ex.toString());
            sb.append("-");
            DFS(split, sb, count + 1);
        }
    }
}