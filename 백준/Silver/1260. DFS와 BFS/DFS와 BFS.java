import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        List<List<Integer>> dot = new ArrayList<>();
        for (int i = 0; i <= n; i++) dot.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dot.get(a).add(b);
            dot.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) Collections.sort(dot.get(i));
        boolean[] ch = new boolean[n + 1];
        ch[v] = true;
        DFS(dot, v, ch);
        sb.append("\n").append(BFS(dot, v, n));
        System.out.println(sb);
    }

    static void DFS(List<List<Integer>> dot, int v, boolean[] ch) {
        sb.append(v).append(" ");
        List<Integer> list = dot.get(v);
        for (int i = 0; i < list.size(); i++) {
            int id = list.get(i);
            if (!ch[id]) {
                ch[id] = true;
                DFS(dot, id, ch);
            }
        }
    }

    static String BFS(List<List<Integer>> dot, int v, int n) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] ch = new boolean[n + 1];
        ch[v] = true;
        q.offer(v);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(" ");
            List<Integer> list = dot.get(num);
            for (int i = 0; i < list.size(); i++) {
                int id = list.get(i);
                if (!ch[id]) {
                    ch[id] = true;
                    q.offer(id);
                }
            }
        }
        return sb.toString();
    }
}