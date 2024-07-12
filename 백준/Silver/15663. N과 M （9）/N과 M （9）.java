import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] number, arr;
    static boolean[] ch;
    static Set<String> set = new HashSet<>();
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
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < m; i++) tmp.append(arr[i]).append(" ");
            String str = tmp.toString();
            if (set.contains(str)) return;
            set.add(str);
            sb.append(str).append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!ch[i]) {
                ch[i] = true;
                arr[count] = number[i];
                DFS(count + 1);
                ch[i] = false;
            }
        }
    }
}