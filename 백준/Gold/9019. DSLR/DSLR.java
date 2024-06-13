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
                add(num * 2 % 10000, ch[num] + "D");
                add(num == 0? 9999: num - 1, ch[num] + "S");
                add(num % 1000 * 10 + num / 1000, ch[num] + "L");
                add(num % 10 * 1000 + num / 10, ch[num] + "R");
            }
        }
        return "";
    }
    
    static void add(int num, String command) {
        if (ch[num] == null) {
            ch[num] = command;
            q.offer(num);
        }
    }
}
