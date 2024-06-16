import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static int[] move, step;
    static Deque<Integer> q;
    
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        n = read();
        k = read();
        move = new int[100001];
        step = new int[100001];
        q = new ArrayDeque<>();
        q.offer(k);
        step[k] = 1;
        while (!q.isEmpty()) {
            int num = q.poll();
            int s = step[num] + 1;
            int teleport = num / 2;
            if (num % 2 == 0) {
                add(teleport, num, s);
                if (teleport == n) break;
            }
            add(num + 1, num, s);
            if (num + 1 == n) break;
            add(num - 1, num, s);
            if (num - 1 == n) break;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(step[n] - 1).append("\n");
        int tmp = n;
        while (tmp != k) {
            sb.append(tmp).append(" ");
            tmp = move[tmp];
        }
        sb.append(k);
        System.out.println(sb);
    }
    
    static void add(int num, int ex, int s) {
        if (num >= 0 && num < 100001 && step[num] == 0) {
            move[num] = ex;
            step[num] = s;
            q.offer(num);
        }
    }
}