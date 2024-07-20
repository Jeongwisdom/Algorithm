import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = n * (n * n + 1) / 2;
        int[][] arr = new int[n][n];
        boolean answer = true;
        boolean[] ch = new boolean[n * n + 1];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (ch[arr[i][j]]) answer = false;
                else ch[arr[i][j]] = true;
            }
        }
        
        if (answer) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < n; i++) {
                a += arr[i][i];
                b += arr[n - 1 - i][n - 1 - i];
            }
            if (a != sum || b != sum) answer = false;
        }
        if (answer) {
            for (int i = 0; i < n; i++) {
                int row = 0;
                int column = 0;
                for (int j = 0; j < n; j++) {
                    row += arr[i][j];
                    column += arr[j][i];
                }
                if (row != sum || column != sum) {
                    answer = false;
                    break;
                }
            }
        }
        System.out.println(answer? "TRUE": "FALSE");
    }
}