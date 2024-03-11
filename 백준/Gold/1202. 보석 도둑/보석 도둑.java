import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] crystal = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            crystal[i][0] = Integer.parseInt(st.nextToken());
            crystal[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(crystal, (c1, c2) -> {
            if (c1[0] == c2[0]) return c2[1] - c1[1];
            return c1[0] - c2[0];
        });
        Arrays.sort(bag);
        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0, j = 0; i < k; i++) {
            while (j < n && bag[i] >= crystal[j][0]) {
                pq.offer(crystal[j][1]);
                j++;
            }
            answer += pq.isEmpty()? 0: pq.poll();
        }
        System.out.println(answer);
    }
}