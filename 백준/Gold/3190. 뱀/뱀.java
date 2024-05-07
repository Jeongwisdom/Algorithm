import java.util.*;

class Main {
    static int read(boolean ch) throws Exception {
        int c, n = System.in.read();
        if (!ch) n = n & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read(false);
        int[][] arr = new int[n][n];
        int k = read(false);
        for (int i = 0; i < k; i++) {
            arr[read(false) - 1][read(false) - 1] = 4;
        }
        int l = read(false);
        int t = 0;
        int x = 0;
        int y = 0;
        int d = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        arr[0][0]++;
        loop:
        for (int i = 0; i <= l; i++) {
            int time;
            char c;
            if (i == l) {
                time = Integer.MAX_VALUE;
                c = 'D';
            } else {
                time = read(false);
                c = (char) read(true);
            }
            while (t < time) {
                x += dx[d];
                y += dy[d];
                t++;
                if (x >= n || x < 0 || y >= n || y < 0 || arr[x][y] % 4 != 0) break loop;
                arr[x][y]++;
                q.offer(new int[] {x, y});
                if (arr[x][y] == 1) {
                    int[] dxy = q.poll();
                    arr[dxy[0]][dxy[1]] = 0;
                }
            }
            if (c == 'L') d = d == 0? 3: d - 1;
            else d = d == 3? 0: d + 1;
        }
        System.out.println(t);
    }
}