import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;
        int one = 0;
        int two = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) one++;
                else if (arr[i][j] == 2) two++;
            }
        }

        int answer = 0;
        if (two - one == 1 && two > 1) {
            answer = find(arr, 0, n, 0, n, true);
            answer += find(arr, 0, n, 0, n, false);
        } else if (two == 1 && one == 0) answer = 1;
        if (answer == 0) answer = -1;
        System.out.println(answer);
    }

    static int find(int[][] arr, int x1, int x2, int y1, int y2, boolean row) {
        int count = 0;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (arr[i][j] == 1) {
                    if (row && isCut(arr, i, y1, y2, true)) {
                        count += check(arr, x1, i, y1, y2, true) * check(arr, i + 1, x2, y1, y2, true);
                    }else if (!row && isCut(arr, j, x1, x2, false)) {
                        count += check(arr, x1, x2, y1, j, false) * check(arr, x1, x2, j + 1, y2, false);
                    }
                }
            }
        }
        return count;
    }

    static int check(int[][] arr, int x1, int x2, int y1, int y2, boolean row) {
        int one = 0;
        int two = 0;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (arr[i][j] == 1) one++;
                else if (arr[i][j] == 2) two++;
            }
        }
        if (two - one == 1) {
            if (two == 1) return 1;
            else {
                return find(arr, x1, x2, y1, y2, !row);
            }
        } else return 0;
    }

    static boolean isCut(int[][] arr, int x, int y1, int y2, boolean row) {
        for (int i = y1; i < y2; i++) {
            if (row) {
                if (arr[x][i] == 2) return false;
            } else {
                if (arr[i][x] == 2) return false;
            }
        }
        return true;
    }
}