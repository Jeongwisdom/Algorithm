import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr, island;
    static Queue<int[]> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0;  j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        island = new int[n][n];
        q = new ArrayDeque<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] == 0 && arr[i][j] == 1) {
                    check(i, j, num++);
                }
            }
        }
        
        int count = 1;
        int answer = Integer.MAX_VALUE;
        while (answer == Integer.MAX_VALUE) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    num = island[p[0]][p[1]];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (island[nx][ny] == 0) {
                            island[nx][ny] = num;
                            q.offer(new int[] {nx, ny});
                        } else if (island[nx][ny] != num) {
                            if (island[nx][ny] > num) answer = Math.min(answer, (count - 1) * 2);
                            else answer = Math.min(answer, count * 2 - 1);
                        }
                    }
                }
            }
            count++;
        }
        System.out.println(answer);
    }
    
    static void check(int x, int y, int num) {
        island[x][y] = num;
        q.offer(new int[] {x, y});
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && island[nx][ny] == 0 && arr[nx][ny] == 1) check(nx, ny, num);
        }
    }
}