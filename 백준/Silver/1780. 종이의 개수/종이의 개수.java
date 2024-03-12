import java.util.*;
import java.io.*;

class Main {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(arr, n, 0, 0);
        System.out.println(minus + "\n" + zero + "\n" + plus);
    }

    public static void divide(int[][] arr, int n, int x, int y) {
        boolean ch = true;
        int first = arr[x][y];
        loop:
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != first) {
                    ch = false;
                    break loop;
                }
            }
        }

        if (!ch) {
            for (int i = x; i < x + n; i += n / 3) {
                for (int j = y; j < y + n; j += n / 3) {
                    divide(arr, n / 3, i, j);
                }
            }
        } else {
            if (first == -1) minus++;
            else if (first == 0) zero++;
            else plus++;
        }
    }
}