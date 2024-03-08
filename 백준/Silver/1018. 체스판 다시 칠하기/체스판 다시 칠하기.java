import java.util.*;
import java.io.*;

class Main {
    static int min = 64;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                check(arr, i, j);
            }
        }
        
        System.out.println(min);
    }
    
    public static void check(char[][] arr, int n, int m) {
        int count = 0;
        char c = arr[n][m];
        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if (arr[i][j] != c) count++;
                if (c == 'B') c = 'W';
                else c = 'B';
            }
            if (c == 'B') c = 'W';
            else c = 'B';
        }
        
        count = count > 32? 64 - count: count;
        min = Math.min(min, count);
    }
}