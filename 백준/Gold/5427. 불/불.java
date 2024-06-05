import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        StringTokenizer st;
        for (int c = 0; c < t; c++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] arr = new char[h][w];
            Queue<int[]> q = new ArrayDeque<>();
            int[] s = new int[3];
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == '*') q.offer(new int[] {i, j});
                    else if (arr[i][j] == '@') s = new int[] {i, j};
                }
            }
            q.offer(s);
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
                            if (arr[point[0]][point[1]] == '@') {
                                q.offer(new int[] {0});
                                break loop;
                            }
                        } else {
                            if (arr[nx][ny] == '.') {
                                arr[nx][ny] = arr[point[0]][point[1]];
                                q.offer(new int[] {nx, ny});
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