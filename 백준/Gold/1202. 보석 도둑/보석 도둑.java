import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new PriorityQueue<>((c1, c2) -> {
            if (c2[1] == c1[1]) return c1[0] - c2[0];
            return c2[1] - c1[1];
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        TreeMap<Integer, Integer> bag = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            int m = Integer.parseInt(br.readLine());
            bag.put(m, bag.getOrDefault(m, 0) + 1);
        }
        
        long answer = 0;
        while (!q.isEmpty() && k > 0) {
            int[] crystal = q.poll();
            Integer key = bag.ceilingKey(crystal[0]);
            if (key != null) {
                if (bag.get(key) > 1) bag.put(key, bag.get(key) - 1);
                else bag.remove(key);
                answer += crystal[1];
                k--;
            }
        }
        System.out.println(answer);
    }
}