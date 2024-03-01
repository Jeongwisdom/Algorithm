import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) return enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        while (answer < enemy.length && (n >= enemy[answer] || k > 0)) {
            if (n >= enemy[answer]) {
                pq.offer(enemy[answer]);
                n -= enemy[answer];
            } else {
                if (!pq.isEmpty() && pq.peek() > enemy[answer]) {
                    n += pq.poll();
                    pq.offer(enemy[answer]);
                    n -= enemy[answer];
                    k--;
                } else k--;
            }
            answer++;
        }
        
        return answer;
    }
}