import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {1, truck_weights[0]});
        int answer = 1;
        int sum = truck_weights[0];
        int i = 1;
        while (!queue.isEmpty()) {
            answer++;
            if (answer - queue.peek()[0] == bridge_length) sum -= queue.poll()[1];
            if (i < truck_weights.length && queue.size() < bridge_length && sum + truck_weights[i] <= weight) {
                sum += truck_weights[i];
                queue.offer(new int[] {answer, truck_weights[i++]});
            }
        }
        
        return answer;
    }
}