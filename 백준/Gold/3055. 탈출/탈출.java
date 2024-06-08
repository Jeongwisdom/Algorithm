import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        Queue<int[]> q = new ArrayDeque<>();
        int[] s = new int[2];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == '*') q.offer(new int[] {i, j});
                else if (arr[i][j] == 'S') s = new int[] {i, j};
            }
        }
        q.offer(s);
        
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        loop:
        while (!q.isEmpty()) {
            int len = q.size();
            answer++;
            for (int i = 0; i < len; i++) {
                int[] point = q.poll();
                int x = point[0];
                int y = point[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if (arr[nx][ny] == 'D') {
                            if (arr[x][y] == 'S') {
                                q.offer(s);
                                break loop;
                            }
                        } else if (arr[nx][ny] == '.') {
                            arr[nx][ny] = arr[x][y];
                            q.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
        }
        if (q.isEmpty()) System.out.println("KAKTUS");
        else System.out.println(answer);
    }
}