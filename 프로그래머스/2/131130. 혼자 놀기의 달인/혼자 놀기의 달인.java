import java.util.*;

class Solution {
    public int solution(int[] cards) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] ch = new boolean[cards.length];
        for (int i = 0; i < ch.length; i++) {
            int num = 0;
            int j = i;
            while (!ch[j]) {
                ch[j] = true;
                j = cards[j] - 1;
                num++;
            }
            q.offer(num);
        }
        
        return q.poll() * (q.isEmpty()? 0: q.poll());
    }
}