import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int answer = 100;
    
    public int solution(int n, int[][] wires) {
        for (int[] wire: wires) {
            for (int i = 0; i < wire.length; i++) {
                List<Integer> list = map.getOrDefault(wire[i], new ArrayList<>());
                list.add(wire[Math.abs(i - 1)]);
                map.put(wire[i], list);
            }
        }
        
        DFS(n, 1, new boolean[n + 1]);
        
        return answer;
    }
    
    public int DFS(int n, int id, boolean[] ch) {
        int plus = 1;
        ch[id] = true;
        for (int i: map.get(id)) {
            if (!ch[i]) {
                plus += DFS(n, i, ch);
            }
        }
        
        answer = Math.min(answer, Math.abs(plus - (n - plus)));
        return plus;
    }
}