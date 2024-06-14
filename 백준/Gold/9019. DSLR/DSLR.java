import java.io.*;
import java.util.*;

class Main {
    static int n, a, b;
    static int[] id;
    static char[] c;
    static Queue<Integer> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(BFS()).append("\n");
        }
        System.out.println(sb);
    }
    
    static String BFS() {
        q = new ArrayDeque<>();
        id = new int[10000];
        for (int i = 0; i < 10000; i++) id[i] = -1;
        c = new char[10000];
        q.offer(a);
        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == b) break;
            int twice = num * 2 % 10000;
            add(twice, num, 'D');
            int minus = num == 0? 9999: num - 1;
            add(minus, num, 'S');
            int l = num % 1000 * 10 + num / 1000;
            add(l, num, 'L');
            int r = num % 10 * 1000 + num / 10;
            add(r, num, 'R');
        }
        
        StringBuilder sb = new StringBuilder();
        int idx = b;
        while (idx != a) {
            sb.append(c[idx]);
            idx = id[idx];
        }
        return sb.reverse().toString();
    }
    
    static void add(int num, int ex, char command) {
        if (id[num] == -1) {
            c[num] = command;
            id[num] = ex;
            q.offer(num);
        }
    }
}
