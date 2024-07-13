import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] number, arr;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        number = new int[n];
        for (int i = 0; i < n; i++) number[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(number);
        arr = new int[m];
        ch = new boolean[n];
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
            if (!ch[i] && store != number[i]) {
                ch[i] = true;
                store = number[i];
                arr[count] = number[i];
                DFS(count + 1);
                ch[i] = false;
            }
        }
    }
}