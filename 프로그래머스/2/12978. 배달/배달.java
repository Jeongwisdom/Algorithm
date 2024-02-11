import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 0; i < road.length; i++) {
            arr[road[i][0]][road[i][1]] = arr[road[i][0]][road[i][1]] == 0? road[i][2]: Math.min(arr[road[i][0]][road[i][1]], road[i][2]);
            arr[road[i][1]][road[i][0]] = arr[road[i][1]][road[i][0]] == 0? road[i][2]: Math.min(arr[road[i][1]][road[i][0]], road[i][2]);
        }
        
        int[] dis = new int[N + 1];
        for (int i = 2; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        Queue<int[]> queue = new PriorityQueue<>((q1, q2) -> q1[1] - q2[1]);
        queue.offer(new int[] {1, 0});
        int[] n;
        while (!queue.isEmpty()) {
            n = queue.poll();
            if (dis[n[0]] >= n[1]) {
                for (int i = 2; i < arr.length; i++) {
                    if (arr[n[0]][i] != 0 && dis[i] > dis[n[0]] + arr[n[0]][i]) {
                        dis[i] = dis[n[0]] + arr[n[0]][i];
                        queue.offer(new int[] {i, arr[n[0]][i]});
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