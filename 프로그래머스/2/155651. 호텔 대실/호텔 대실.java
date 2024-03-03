import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(book_time, (b1, b2) -> b1[0].compareTo(b2[0]));
        int answer = 0;
        for (int i = 0; i < book_time.length; i++) {
            int start = getTime(book_time[i][0]);
            int end = getTime(book_time[i][1]) + 10;
            while (!pq.isEmpty() && start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(end);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    public int getTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}