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
        
        q = new ArrayDeque<>();
        int[] horse = {2, -2};
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        q.offer(new int[] {0, 0, 0});
        for (int i = 0; i < k + 1; i++) arr[0][0][0] = 1;
        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int step = arr[p[2]][p[0]][p[1]];
            if (p[0] == h - 1 && p[1] == w - 1) {
                answer = step;
                break;
            }
            if (p[2] < k) {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 4; j++) {
                        int nx = p[0] + (dx[j] == 0? horse[i]: dx[j]);
                        int ny = p[1] + (dy[j] == 0? horse[i]: dy[j]);
                        add(nx, ny, p[2] + 1, step + 1);
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                add(nx, ny, p[2], step + 1);
            }
        }
        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(--answer);
    }
    
    static void add(int x, int y, int num, int step) {
        if (x >= 0 && y >= 0 && x < h && y < w && arr[0][x][y] == 0 && arr[num][x][y] == 0) {
            arr[num][x][y] = step;
            q.offer(new int[] {x, y, num});
        }
    }
}