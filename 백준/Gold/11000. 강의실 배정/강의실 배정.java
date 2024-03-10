import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (i1, i2) ->  i1[0] - i2[0]);
        Queue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek() <= arr[i][0]) {
                pq.poll();
            }
            pq.offer(arr[i][1]);
            answer = Math.max(answer, pq.size());
        }
        System.out.println(answer);
    }
}