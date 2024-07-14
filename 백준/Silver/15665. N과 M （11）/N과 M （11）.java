import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] number, arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        number = new int[n];
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) number[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(number);
        DFS(0);
        System.out.println(sb);
    }
    
    static void DFS(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        int store = 0;
        for (int i = 0; i < n; i++) {
            if (store != number[i]) {
                store = number[i];
                arr[count] = store;
                DFS(count + 1);
            }
        }
    }
}