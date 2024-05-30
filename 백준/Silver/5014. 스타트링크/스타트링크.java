import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        boolean[] ch = new boolean[f + 1];
        Queue<Integer> q = new ArrayDeque<>();
        int answer = 0;
        ch[s] = true;
        q.offer(s);
        loop:
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int num = q.poll();
                if (num == g) break loop;
                if (num + u <= f && !ch[num + u]) {
                    ch[num + u] = true;
                    q.offer(num + u);
                }
                if (num - d > 0 && !ch[num - d]) {
                    ch[num - d] = true;
                    q.offer(num - d);
                }
            }
            answer++;
        }
        System.out.println(!ch[g]? "use the stairs": answer);
    }
}