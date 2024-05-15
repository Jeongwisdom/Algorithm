import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 2; i <= 20; i++) map.put(i, new ArrayDeque<>());
        Queue<Integer> q;
        long answer = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            q = map.get(str.length());
            q.offer(i);
            while (q.peek() < i - k) q.poll();
            answer += q.size() - 1;
        }
        System.out.println(answer);
    }
}