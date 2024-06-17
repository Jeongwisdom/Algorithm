import java.io.*;
import java.util.*;

class Main {
    static int k, w, h;
    static int[][][] arr;
    static Deque<int[]> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[k + 1][h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[0][i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(BFS());
    }
    
    static int BFS() {
        q = new ArrayDeque<>();
        int[] hx = {2, 2, -2, -2, -1, -1, 1, 1};
        int[] hy = {1, -1, 1, -1, 2, -2, 2, -2};
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        q.offer(new int[] {0, 0, 0});
        arr[0][0][0] = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int step = arr[p[2]][p[0]][p[1]];
            if (p[0] == h - 1 && p[1] == w - 1) {
                return step - 1;
            }
            if (p[2] < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = p[0] + hx[i];
                    int ny = p[1] + hy[i];
                    add(nx, ny, p[2] + 1, step + 1);
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                add(nx, ny, p[2], step + 1);
            }
        }
        return -1;
    }
    
    static void add(int x, int y, int num, int step) {
        if (x >= 0 && y >= 0 && x < h && y < w && arr[0][x][y] == 0 && arr[num][x][y] == 0) {
            arr[num][x][y] = step;
            q.offer(new int[] {x, y, num});
        }
    }
}