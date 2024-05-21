import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        boolean[] ch = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!ch[i]) {
                answer++;
                ch[i] = true;
                q.offer(i);
            }
            while (!q.isEmpty()) {
                int a = q.poll();
                l = list.get(a);
                for (int b: l) {
                    if (!ch[b]) {
                        ch[b] = true;
                        q.offer(b);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}