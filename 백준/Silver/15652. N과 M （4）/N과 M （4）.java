import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        DFS(1, 0);
        System.out.println(sb);
    }
    
    static void DFS(int ex, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
        } else {
            for (int i = ex; i <= n; i++) {
                arr[count] = i;
                DFS(i, count + 1);
            }
        }
    }
}