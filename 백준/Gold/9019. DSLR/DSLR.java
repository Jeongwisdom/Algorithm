import java.io.*;
import java.util.*;

class Main {
    static int[] id;
    static char[] c;
    static Queue<Integer> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            q = new ArrayDeque<>();
            id = new int[10000];
            c = new char[10000];
            q.offer(a);
            while (!q.isEmpty()) {
                int num = q.poll();
                int twice = num * 2 % 10000;
                add(twice, num, 'D');
                if (twice == b) break;
                int minus = num == 0? 9999: num - 1;
                add(minus, num, 'S');
                if (minus == b) break;
                int l = num % 1000 * 10 + num / 1000;
                add(l, num, 'L');
                if (l == b) break;
                int r = num % 10 * 1000 + num / 10;
                add(r, num, 'R');
                if (r == b) break;
            }
            
            StringBuilder tmp = new StringBuilder();
            int idx = b;
            while (idx != a) {
                tmp.append(c[idx]);
                idx = id[idx] - 1;
            }
            sb.append(tmp.reverse().toString()).append("\n");
        }
        System.out.println(sb);
    }
    
    static void add(int num, int ex, char command) {
        if (id[num] == 0) {
            c[num] = command;
            id[num] = ex + 1;
            q.offer(num);
        }
    }
}
