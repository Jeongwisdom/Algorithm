import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = st.nextToken().charAt(0) == '1';
            }
        }
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            DFS(arr, ch, i, n);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]? 1: 0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(boolean[][] arr, int[] ch, int id, int n) {
        if (ch[id] < 2) {
            ch[id]++;
            for (int i = 0; i < n; i++) {
                if (arr[id][i]) {
                    DFS(arr, ch, i, n);
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j]) arr[id][j] = true;
                    }
                }
            }
        }
    }
}