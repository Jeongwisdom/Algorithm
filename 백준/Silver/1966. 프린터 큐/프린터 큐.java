import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        Queue<int[]> q;
        int t = read();
        for (int i = 0; i < t; i++) {
            int n = read();
            int m = read();
            q = new ArrayDeque<>();
            int[] im = new int[n];
            for (int j = 0; j < n; j++) {
                int num = read();
                q.offer(new int[] {j, num});
                im[j] = num;
            }
            Arrays.sort(im);
            int id = n - 1;
            int c = 0;
            while (!q.isEmpty()) {
                if (q.peek()[1] == im[id]) {
                    c++;
                    id--;
                    if (q.peek()[0] == m) {
                        sb.append(c).append("\n");
                        break;
                    } else q.poll();
                } else {
                    q.offer(q.poll());
                }
            }
        }
        System.out.println(sb);
    }
}