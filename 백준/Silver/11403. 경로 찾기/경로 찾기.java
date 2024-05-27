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
                if (st.nextToken().charAt(0) == '1') arr[i][j] = true;
            }
        }
        boolean[] ch;
        for (int i = 0; i < n; i++) {
            ch = new boolean[n];
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

    static void DFS(boolean[][] arr, boolean[] ch, int id, int n) {
        if (!ch[id]) {
            ch[id] = true;
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