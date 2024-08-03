import java.io.*;
import java.util.*;

class Main {
    static int n, m, h, answer = -1;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][n + 1];
        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = 1;
            arr[a][b + 1] = -1;
        }

        for (int i = 0; i < 4; i++) {
            DFS(0, 0, 0, i);
            if (answer == i) break;
        }
        System.out.println(answer);
    }

    static void DFS(int x, int y, int count, int goal) {
        if (goal == answer) return;
        if (count == goal) {
            if (climb()) answer = count;
            return;
        }

        if (y >= n) {
            x++;
            y = 0;
        }
        if (x == h) return;

        if (arr[x][y] == 0 && arr[x][y + 1] == 0) {
            arr[x][y] = 1;
            arr[x][y + 1] = -1;
            DFS(x, y + 2, count + 1, goal);
            arr[x][y] = 0;
            arr[x][y + 1] = 0;
        }
        DFS(x, y + 1, count, goal);
    }

    static boolean climb() {
        for (int i = 0; i < n - 1; i++) {
            int ladder = i;
            for (int j = 0; j < h; j++) {
                ladder += arr[j][ladder];
            }
            if (ladder != i) return false;
        }
        return true;
    }
}