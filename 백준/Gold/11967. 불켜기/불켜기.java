import java.io.*;
import java.util.*;

class Main {
    static int n, answer = 1;
    static boolean[][] light, ch;
    static Deque<int[]> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Point[][] arr = new Point[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (arr[x1][y1] == null) arr[x1][y1] = new Point();
            arr[x1][y1].add(x2, y2);
        }

        q = new ArrayDeque<>();
        light = new boolean[n + 1][n + 1];
        ch = new boolean[n + 1][n + 1];
        q.offer(new int[] {1, 1});
        light[1][1] = true;
        ch[1][1] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            if (arr[x][y] != null) {
                Point point = arr[x][y];
                for (int i = 0; i < point.x.size(); i++) {
                    if (!light[point.x.get(i)][point.y.get(i)]) {
                        light[point.x.get(i)][point.y.get(i)] = true;
                        answer++;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx > 0 && ny > 0 && nx <= n && ny <= n && !ch[nx][ny] && light[nx][ny]) {
                    ch[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }

            if (q.isEmpty()) {
                DFS(new boolean[n + 1][n + 1], x, y);
            }
        }
        System.out.println(answer);
    }

    static void DFS(boolean[][] move, int x, int y) {
        move[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > 0 && ny > 0 && nx <= n && ny <= n && !move[nx][ny] && light[nx][ny]) {
                move[nx][ny] = true;
                if (!ch[nx][ny]) {
                    ch[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
                DFS(move, nx, ny);
            }
        }
    }
}

class Point {
    List<Integer> x;
    List<Integer> y;

    public Point() {
        x = new ArrayList<>();
        y = new ArrayList<>();
    }

    public void add(int x, int y) {
        this.x.add(x);
        this.y.add(y);
    }
}
