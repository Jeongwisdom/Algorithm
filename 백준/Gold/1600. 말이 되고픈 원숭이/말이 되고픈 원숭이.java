import java.io.*;
import java.util.*;

class Main {
    static int k, w, h;
    static int[][] arr;
    static boolean[][][] ch;
    static Deque<int[]> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(BFS());
    }
    
    static int BFS() {
        ch = new boolean[k + 1][h][w];
        q = new ArrayDeque<>();
        int[] hx = {2, 2, -2, -2, -1, -1, 1, 1};
        int[] hy = {1, -1, 1, -1, 2, -2, 2, -2};
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        q.offer(new int[] {0, 0, 0, 0});
        ch[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == h - 1 && p[1] == w - 1) {
                return p[3];
            }
            if (p[2] < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = p[0] + hx[i];
                    int ny = p[1] + hy[i];
                    add(nx, ny, p[2] + 1, p[3] + 1);
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                add(nx, ny, p[2], p[3] + 1);
            }
        }
        return -1;
    }
    
    static void add(int x, int y, int num, int step) {
        if (x >= 0 && y >= 0 && x < h && y < w && arr[x][y] == 0 && !ch[num][x][y]) {
            ch[num][x][y] = true;
            q.offer(new int[] {x, y, num, step});
        }
    }
}