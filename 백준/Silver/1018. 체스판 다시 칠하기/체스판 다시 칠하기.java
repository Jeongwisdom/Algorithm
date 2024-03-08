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
        boolean[][] ch = new boolean[n][m];
        for (int i = 1; i < m; i++) {
            if (arr[0][i] == arr[0][i - 1]) {
                ch[0][i] = true;
                if (arr[0][i] == 'B') arr[0][i] = 'W';
                else arr[0][i] = 'B';
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[j][i] == arr[j - 1][i]) {
                    ch[j][i] = true;
                    if (arr[j][i] == 'B') arr[j][i] = 'W';
                    else arr[j][i] = 'B';
                }
            }
        }
        
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                check(ch, i, j);
            }
        }
        
        System.out.println(min);
    }
    
    public static void check(boolean[][] ch, int n, int m) {
        int count = 0;
        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if (ch[i][j]) count++;
            }
        }
        count = count > 32? 64 - count: count;
        min = Math.min(min, count);
    }
}