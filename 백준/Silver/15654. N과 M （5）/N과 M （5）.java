import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] arr, number;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        number = new int[n];
        ch = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(number);
        arr = new int[m];
        DFS(0);
        System.out.println(sb);
    }
    
    static void DFS(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!ch[i]) {
                arr[count] = number[i];
                ch[i] = true;
                DFS(count + 1);
                ch[i] = false;
            }
        }
    }
}