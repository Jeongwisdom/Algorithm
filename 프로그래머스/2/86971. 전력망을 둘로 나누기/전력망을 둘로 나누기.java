import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    public int solution(int n, int[][] wires) {
        for (int[] wire: wires) {
            for (int i = 0; i < wire.length; i++) {
                List<Integer> list = map.getOrDefault(wire[i], new ArrayList<>());
                list.add(wire[Math.abs(i - 1)]);
                map.put(wire[i], list);
            }
        }
        
        int answer = Integer.MAX_VALUE;
        boolean[] ch = new boolean[n + 1];
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if (entry.getValue().size() > 1) {
                Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                ch[entry.getKey()] = true;
                for (int id: entry.getValue()) {
                    pq.offer(get(id, ch));
                }
                ch[entry.getKey()] = false;
                int max = pq.poll();
                int min = 1;
                while (!pq.isEmpty()) {
                    min += pq.poll();
                }
                answer = Math.min(answer, Math.abs(max - min));
            }
        }
        
        return answer;
    }
    
    public int get(int id, boolean[] ch) {
        List<Integer> list = map.get(id);
        int sum = 1;
        ch[id] = true;
        for (int i: list) {
            if (!ch[i]) {
                ch[i] = true;
                sum += get(i, ch);
                ch[i] = false;
            }
        }
        ch[id] = false;

        return sum;
    }
}