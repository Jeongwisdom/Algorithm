import java.io.*;
import java.util.*;

class Main {
    static int n, a, b;
    static boolean[] ch;
    static Queue<Number> q;
    
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
        ch = new boolean[10000];
        q.offer(new Number(a, new StringBuilder()));
        ch[a] = true;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0;  i < len; i++) {
                Number num = q.poll();
                if (num.num == b) return num.sb.toString();
                add(num.num * 2 % 10000, num.sb.toString(), "D");
                add(num.num == 0? 9999: num.num - 1, num.sb.toString(), "S");
                add(num.findLeft(), num.sb.toString(), "L");
                add(num.findRight(), num.sb.toString(), "R");
            }
        }
        return "";
    }
    
    static void add(int num, String ex, String command) {
        if (!ch[num]) {
            ch[num] = true;
            StringBuilder tmp = new StringBuilder(ex);
            tmp.append(command);
            q.offer(new Number(num, tmp));
        }
    }
}

class Number {
    int num;
    StringBuilder sb;
       
    Number(int num, StringBuilder sb) {
        this.num = num;
        this.sb = sb;
    }
    
    public int findLeft() {
        return this.num % 1000 * 10 + this.num / 1000;
    }
    
    public int findRight() {
        return this.num % 10 * 1000 + this.num / 10;
    }
}
