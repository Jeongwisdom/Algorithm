import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = st.nextToken().charAt(0);
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
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(char[][] arr, boolean[] ch, int id, int n) {
        if (!ch[id]) {
            ch[id] = true;
            for (int i = 0; i < n; i++) {
                if (arr[id][i] == '1') {
                    DFS(arr, ch, i, n);
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] == '1') arr[id][j] = '1';
                    }
                }
            }
        }
    }
}