import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) q.add(i);
        while (q.size() > 1) {
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.peek());
    }
}