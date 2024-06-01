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
        boolean[][] dot = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dot[a][b] = true;
            dot[b][a] = true;
        }
        boolean[] ch = new boolean[n + 1];
        ch[v] = true;
        DFS(dot, v, ch);
        sb.append("\n").append(BFS(dot, v));
        System.out.println(sb);
    }

    static void DFS(boolean[][] dot, int v, boolean[] ch) {
        sb.append(v).append(" ");
        for (int i = 0; i < dot.length; i++) {
            if (!ch[i] && dot[v][i]) {
                ch[i] = true;
                DFS(dot, i, ch);
            }
        }
    }

    static String BFS(boolean[][] dot, int v) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] ch = new boolean[dot.length];
        ch[v] = true;
        q.offer(v);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(" ");
            for (int i = 0; i < dot.length; i++) {
                if (!ch[i] && dot[num][i]) {
                    ch[i] = true;
                    q.offer(i);
                }
            }
        }
        return sb.toString();
    }
}