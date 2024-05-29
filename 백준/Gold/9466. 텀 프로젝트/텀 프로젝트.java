import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int c = 0; c < t; c++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] ch = new boolean[n + 1];
            Deque<Integer> q;
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                q = new ArrayDeque<>();
                q.offer(i);
                while (!ch[q.peekLast()]) {
                    ch[q.peekLast()] = true;
                    q.offer(arr[q.peekLast()]);
                }
                while (!Objects.equals(q.peek(), q.peekLast())) q.poll();
                answer += q.size() - 1;
            }
            sb.append(n - answer).append("\n");
        }
        System.out.println(sb);
    }
}