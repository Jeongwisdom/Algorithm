import java.io.*;
import java.util.*;

class Main {
    static boolean[] diagonal1, diagonal2;
    static int[][] arr;
    static int n, even = 0, odd = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        diagonal1 = new boolean[2 * n - 1];
        diagonal2 = new boolean[2 * n - 1];
        DFS(0, 0, 0, true);
        DFS(0, 1, 0, false);
        System.out.println(even + odd);
    }

    static void DFS(int x, int y, int count, boolean isEven) {
        while (y >= n || (x < n && arr[x][y] == 0) || (x < n && (diagonal1[n + (x - y) - 1] || diagonal2[x + y]))) {
            y += 2;
            if (y >= n) {
                x++;
                if (isEven) y = x & 1;
                else y = (x + 1) & 1;
            }
        }
        if (x == n) {
            if (isEven) {
                if (even < count) even = count;
            } else {
                if (odd < count) odd = count;
            }
            return;
        }
        int d = n + (x - y) - 1;
        DFS(x, y + 2, count, isEven);
        diagonal1[d] = true;
        diagonal2[x + y] = true;
        DFS(x, y + 2, count + 1, isEven);
        diagonal1[d] = false;
        diagonal2[x + y] = false;
    }
}