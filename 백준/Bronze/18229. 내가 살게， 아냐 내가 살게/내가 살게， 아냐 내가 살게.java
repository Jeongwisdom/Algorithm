import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] cnt = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt[j] += arr[j][i];
                if (cnt[j] >= k) {
                    System.out.println(j + 1 + " " + (i + 1));
                    return;
                }
            }
        }
    }
}