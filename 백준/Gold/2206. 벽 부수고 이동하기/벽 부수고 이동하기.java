import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static String[] arr;
    static boolean[][][] ch;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        ch = new boolean[2][n][m];
        System.out.println(BFS());
    }
    
    static int BFS() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0});
        ch[0][0][0] = true;
        int nx, ny, len, count = 0;
        int[] p;
        while (!q.isEmpty()) {
            count++;
            len = q.size();
            for (int i = 0; i < len; i++) {
                p = q.poll();
                if (p[0] == n - 1 && p[1] == m - 1) return count;
                for (int j = 0; j < 4; j++) {
                    nx = p[0] + dx[j];
                    ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (!ch[p[2]][nx][ny]) {
                            ch[p[2]][nx][ny] = true;
                            if (arr[nx].charAt(ny) == '0') q.offer(new int[] {nx, ny, p[2]});
                            else if (p[2] == 0) q.offer(new int[] {nx, ny, 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}