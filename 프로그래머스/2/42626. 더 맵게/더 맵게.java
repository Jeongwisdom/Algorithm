import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.offer(scoville[i]);
        }
        
        int answer = 0;
        while (queue.size() > 1 && queue.peek() < K) {
            answer++;
            queue.offer(queue.poll() + (queue.poll() * 2));
        }
        
        return queue.peek() < K? -1: answer;
    }
}