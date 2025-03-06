import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num, n = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken()) - 1;
        Deque<int[]> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            while (!q.isEmpty() && q.getFirst()[0] < i - L) q.pollFirst();
            while (!q.isEmpty() && q.getLast()[1] >= num) q.pollLast();
            q.offer(new int[] {i, num});
            sb.append(q.getFirst()[1]).append(" ");
        }
        System.out.println(sb);
    }
}