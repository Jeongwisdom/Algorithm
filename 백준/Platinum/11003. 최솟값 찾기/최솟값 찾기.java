import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()) - 1;
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.getFirst()[0] < i - L) q.pollFirst();
            while (!q.isEmpty() && q.getLast()[1] >= arr[i]) q.pollLast();
            q.offer(new int[] {i, arr[i]});
            sb.append(q.getFirst()[1]).append(" ");
        }
        System.out.println(sb);
    }
}