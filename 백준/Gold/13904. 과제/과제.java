import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<int[]> pq = new PriorityQueue<>((q1, q2) -> {
            if(q2[1] == q1[1]) return q1[0] - q2[0];
            return q2[1] - q1[1];
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        
        int answer = 0;
        boolean[] limit = new boolean[1001];
        while (!pq.isEmpty()) {
            int[] report = pq.poll();
            for (int i = report[0]; i > 0; i--) {
                if (!limit[i]) {
                    limit[i] = true;
                    answer += report[1];
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}