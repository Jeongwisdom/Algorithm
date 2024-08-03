import java.io.*;
import java.util.*;

class Main {
    static int n, m, h, answer = -1;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new boolean[h][n];
        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a - 1][b] = true;
        }

        for (int i = 0; i < 4; i++) {
            DFS(0, 1, 0, i);
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
            y = 1;
        }
        if (x == h) return;
        
        if (check(x, y)) {
            arr[x][y] = true;
            DFS(x, y + 2, count + 1, goal);
            arr[x][y] = false;
        }
        DFS(x, y + 1, count, goal);
    }

    static boolean check(int x, int y) {
        if (arr[x][y]) return false;
        return (y == 0 || !arr[x][y - 1]) && (y == n - 1 || !arr[x][y + 1]);
    }

    static boolean climb() {
        for (int i = 0; i < n - 1; i++) {
            int ladder = i;
            for (int j = 0; j < h; j++) {
                if (arr[j][ladder]) ladder--;
                else if (ladder + 1 < n && arr[j][ladder + 1]) ladder++;
            }
            if (ladder != i) return false;
        }
        return true;
    }
}