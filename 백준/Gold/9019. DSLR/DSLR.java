import java.io.*;
import java.util.*;

class Main {
    static int n, a, b;
    static String[] ch;
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
        ch = new String[10000];
        q.offer(a);
        ch[a] = "";
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0;  i < len; i++) {
                int num = q.poll();
                if (num == b) return ch[num];
                int twice = num * 2 % 10000;
                add(twice, ch[num], "D");
                int minus = num == 0? 9999: num - 1;
                add(minus, ch[num], "S");
                int l = num % 1000 * 10 + num / 1000;
                add(l, ch[num], "L");
                int r = num % 10 * 1000 + num / 10;
                add(r, ch[num], "R");
            }
        }
        return "";
    }
    
    static void add(int num, String ex, String command) {
        if (ch[num] == null) {
            StringBuilder sb = new StringBuilder(ex);
            sb.append(command);
            ch[num] = sb.toString();
            q.offer(num);
        }
    }
}
