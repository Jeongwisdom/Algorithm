import java.util.*;

class Main {
    static int read() throws Exception {
        boolean minus = false;
        int c, n = System.in.read();
        if (n == 45) {
            n = System.in.read();
            minus = true;
        }
        n = n & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -n: n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int L = read() - 1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        int[] d = new int[n];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.getFirst()[0] < i - L) q.pollFirst();
            while (!q.isEmpty() && q.getLast()[1] >= arr[i]) q.pollLast();
            q.offer(new int[] {i, arr[i]});
            d[i] = q.getFirst()[1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(d[i]).append(" ");
        System.out.println(sb);
    }
}