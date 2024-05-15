import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer>[] qs = new Queue[21];
        for (int i = 2; i < 21; i++) qs[i] = new ArrayDeque<>();
        Queue<Integer> q;
        long answer = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            q = qs[str.length()];
            while (!q.isEmpty() && q.peek() < i - k) q.poll();
            answer += q.size();
            q.offer(i);
        }
        System.out.println(answer);
    }
}