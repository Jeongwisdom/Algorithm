import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<int[]> pq = new PriorityQueue<>((q1, q2) -> {
            if(q1[0] == q2[0]) return q2[1] - q1[1];
            return q1[0] - q2[0];
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        
        int day = 0;
        int answer = 0;
        Queue<int[]> q = new PriorityQueue<>((q1, q2) -> q1[1] - q2[1]);
        while (!pq.isEmpty()) {
            int[] report = pq.poll();
            if (day < report[0]) {
                q.offer(report);
                answer += report[1];
                day++;
            } else {
                if (report[1] > q.peek()[1]) {
                    answer += report[1] - q.poll()[1];
                    q.offer(report);
                }
            }
        }
        System.out.println(answer);
    }
}