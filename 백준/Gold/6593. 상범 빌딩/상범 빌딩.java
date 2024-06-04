import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            if (l == 0) break;
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char[][][] b = new char[l][r][c];
            int[] s = new int[3];
            int[] e = new int[3];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < c; k++) {
                        b[i][j][k] = str.charAt(k);
                        if (b[i][j][k] == 'S') s = new int[] {i, j, k};
                        else if (b[i][j][k] == 'E') e = new int[] {i, j, k};
                    }
                }
                br.readLine();
            }
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][][] ch = new boolean[l][r][c];
            int[] dz = {0, 0, 0, 0, -1, 1};
            int[] dx = {-1, 1, 0, 0, 0, 0};
            int[] dy = {0, 0, -1, 1, 0, 0};
            ch[s[0]][s[1]][s[2]] = true;
            q.offer(new int[] {s[0], s[1], s[2]});
            int time = 0;
            loop:
            while (!q.isEmpty()) {
                int len = q.size();
                time++;
                for (int i = 0; i < len; i++) {
                    int[] point = q.poll();
                    for (int j = 0; j < 6; j++) {
                        int nz = point[0] + dz[j];
                        int nx = point[1] + dx[j];
                        int ny = point[2] + dy[j];
                        if (nz >= 0 && nx >= 0 && ny >= 0 && nz < l && nx < r && ny < c && !ch[nz][nx][ny] && b[nz][nx][ny] != '#') {
                            ch[nz][nx][ny] = true;
                            q.offer(new int[] {nz, nx, ny});
                            if (nz == e[0] && nx == e[1] && ny == e[2]) break loop;
                        }
                    }
                }
            }
            if (!ch[e[0]][e[1]][e[2]]) sb.append("Trapped!\n");
            else sb.append("Escaped in ").append(time).append(" minute(s).\n");
        }
        System.out.println(sb);
    }
}