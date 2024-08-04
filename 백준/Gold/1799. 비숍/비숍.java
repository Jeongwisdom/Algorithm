import java.io.*;
import java.util.*;

class Main {
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

        DFS(0, 0, 0, true);
        DFS(0, 0, 0, false);
        System.out.println(even + odd);
    }

    static void DFS(int x, int y, int count, boolean isEven) {
        while (y == n || (x < n && arr[x][y] != 1) || (isEven && (x + y) % 2 == 1) || (!isEven && (x + y) % 2 == 0)) {
            y++;
            if (y >= n) {
                x++;
                y = 0;
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
        int num = count + 2;
        DFS(x, y + 1, count, isEven);
        fill(x, y, 1, num);
        DFS(x, y + 1, count + 1, isEven);
        fill(x, y, num, 1);
    }

    static void fill(int x, int y, int to, int from) {
        for (int i = 0; x + i < n && y >= i; i++) {
            if (arr[x + i][y - i] == to) arr[x + i][y - i] = from;
        }
        for (int i = 0; x + i < n && y + i < n; i++) {
            if (arr[x + i][y + i] == to) arr[x + i][y + i] = from;
        }
    }
}