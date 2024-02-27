import java.util.*;

class Solution {
    public int solution(int[] cards) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] ch = new boolean[cards.length];
        int i = 0;
        int sum = 0;
        while (sum < ch.length) {
            int num = 0;
            while (i < ch.length && ch[i]) i++;
            while (i < ch.length && !ch[i]) {
                ch[i] = true;
                i = cards[i] - 1;
                num++;
            }
            q.offer(num);
            sum += num;
        }
        
        return q.poll() * (q.isEmpty()? 0: q.poll());
    }
}