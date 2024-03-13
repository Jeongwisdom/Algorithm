import java.util.*;
import java.io.*;

class Main {
    static int[] color = new int[2];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        divide(arr, 0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(color[i]).append("\n");
        }
        System.out.println(sb);
    }
    
    public static void divide(int[][] arr, int x, int y, int n) {
        int first = arr[x][y];
        boolean ch = true;
        loop:
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (first != arr[i][j]) {
                    ch = false;
                    break loop;
                }
            }
        }
        
        if (ch) {
            color[first]++;
        } else {
            for (int i = x; i < x + n; i += n / 2) {
                for (int j = y; j < y + n; j += n / 2) {
                    divide(arr, i, j, n / 2);
                }
            }
        }
    }
}