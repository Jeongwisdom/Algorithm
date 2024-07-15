import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] arr, number;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        number = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        DFS(0, 0);
        System.out.println(sb);
    }
    
    static void DFS(int id, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) sb.append(number[i]).append(" ");
            sb.append("\n");
            return;
        }
        int store = 0;
        for (int i = id; i < n; i++) {
            if (store == arr[i]) continue;
            store = arr[i];
            number[count] = arr[i];
            DFS(i, count + 1);
        }
    }
}