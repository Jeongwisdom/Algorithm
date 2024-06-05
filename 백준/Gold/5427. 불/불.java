import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int c = 0; c < t; c++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] arr = new char[h][w];
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] ch = new boolean[h][w];
            int[] s = new int[3];
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == '*') {
                        q.offer(new int[] {i, j, '*'});
                        ch[i][j] = true;
                    } else if (arr[i][j] == '@') s = new int[] {i, j, '@'};
                }
            }
            q.offer(s);
            ch[s[0]][s[1]] = true;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int answer = 0;
            loop:
            while (!q.isEmpty()) {
                int len = q.size();
                answer++;
                for (int i = 0; i < len; i++) {
                    int[] point = q.poll();
                    for (int j = 0; j < 4; j++) {
                        int nx = point[0] + dx[j];
                        int ny = point[1] + dy[j];
                        if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                            if ((char) point[2] == '@') {
                                q.offer(new int[] {0});
                                break loop;
                            }
                        } else {
                            if (!ch[nx][ny] && arr[nx][ny] == '.') {
                                ch[nx][ny] = true;
                                q.offer(new int[] {nx, ny, point[2]});
                            }
                        }
                    }
                }
            }
            if (q.isEmpty()) sb.append("IMPOSSIBLE\n");
            else sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}