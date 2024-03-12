import java.util.*;
import java.io.*;

class Main {
    static int[] num = new int[3];
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        divide(arr, n, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(num[i]).append("\n");
        }
        System.out.println(sb);
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
            num[first]++;
        }
    }
}