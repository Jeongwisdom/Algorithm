import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        Deque<Integer> q = new ArrayDeque<>();
        int n = read();
        int k = read();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!q.isEmpty()) {
            int i = 0;
            while (i < k) {
                i++;
                if (i == k) {
                    sb.append(q.poll());
                    if (!q.isEmpty()) sb.append(", ");
                } else {
                    q.offerLast(q.poll());
                }
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}