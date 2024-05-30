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
        int[] ch = new int[f + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        ch[s] = 1;
        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == g) break;
            if (num + u <= f && ch[num + u] == 0) {
                ch[num + u] = ch[num] + 1;
                q.offer(num + u);
            }
            if (num - d > 0 && ch[num - d] == 0) {
                ch[num - d] = ch[num] + 1;
                q.offer(num - d);
            }
        }
        System.out.println(ch[g] == 0? "use the stairs": ch[g] - 1);
    }
}