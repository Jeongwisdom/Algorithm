import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int f = read();
        int s = read();
        int g = read();
        int u = read();
        int d = read();
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