import java.io.*;
import java.util.*;

class Main {
    static char[][] arr = new char[12][6];
    static boolean[][] ch;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        boolean flag = true;
        int answer = -1;
        while (flag) {
            flag = false;
            answer++;
            ch = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!ch[i][j]) {
                        ch[i][j] = true;
                        if (arr[i][j] != '.' && check(i, j)) {
                            bomb(i, j);
                            arr[i][j] = '.';
                            flag = true;
                        }
                    }
                }
            }
            rebatch();
        }
        System.out.println(answer);
    }

    static boolean check(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] check = new boolean[12][6];
        q.offer(new int[] {x, y});
        check[x][y] = true;
        int num = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && !check[nx][ny]) {
                    check[nx][ny] = true;
                    if (arr[nx][ny] == arr[x][y]) {
                        num++;
                        q.offer(new int[] {nx, ny});
                    }
                }
                if (num >= 4) return true;
            }
        }
        return false;
    }

    static void bomb(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && !ch[nx][ny] && arr[nx][ny] == arr[x][y]) {
                    ch[nx][ny] = true;
                    arr[nx][ny] = '.';
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }

    static void rebatch() {
        for (int i = 0; i < 6; i++) {
            int k = 10;
            for (int j = 11; j >= 0; j--, k--) {
                if (arr[j][i] == '.') {
                    while (k >= 0 && arr[k][i] == '.') {
                        k--;
                    }
                    if (k >= 0) {
                        arr[j][i] = arr[k][i];
                        arr[k][i] = '.';
                    }
                }
            }
        }
    }
}