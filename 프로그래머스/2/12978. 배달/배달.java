import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new HashMap<>());
        }
        for (int i = 0; i < road.length; i++) {
            list.get(road[i][0]).put(road[i][1], Math.min(list.get(road[i][0]).getOrDefault(road[i][1], Integer.MAX_VALUE), road[i][2]));
            list.get(road[i][1]).put(road[i][0], Math.min(list.get(road[i][1]).getOrDefault(road[i][0], Integer.MAX_VALUE), road[i][2]));
        }
        
        int[] dis = new int[N + 1];
        for (int i = 2; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        Queue<int[]> queue = new PriorityQueue<>((q1, q2) -> q1[1] - q2[1]);
        queue.offer(new int[] {1, 0});
        int[] poll;
        Map<Integer, Integer> map;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            if (dis[poll[0]] >= poll[1]) {
                map = list.get(poll[0]);
                for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                    if (dis[entry.getKey()] > dis[poll[0]] + entry.getValue()) {
                        dis[entry.getKey()] = dis[poll[0]] + entry.getValue();
                        queue.offer(new int[] {entry.getKey(), entry.getValue()});
                    }
                }
            }
        }
        
        int answer = 1;
        for (int i = 2; i < dis.length; i++) {
            if (dis[i] <= K) answer++;
        }

        return answer;
    }
}